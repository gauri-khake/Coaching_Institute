package com.asint.coaching.coaching.services;

import cds.gen.coaching.Students;
import com.asint.coaching.coaching.repository.StudentRepository;
import com.sap.cds.services.EventContext;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;

@Component
@ServiceName("StudentService")
public class BulkServices implements EventHandler {

    private static final Logger log = LoggerFactory.getLogger(BulkServices.class);

    private final StudentRepository studentRepository;

    private static final int CHUNK_SIZE = 100;
    private static final int THREAD_COUNT = 5;

    public BulkServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @On
    public void bulkInsertStudents(EventContext context) {
        if (!"bulkInsertStudents".equals(context.getEvent())) {
            return;
        }
        String jobId = UUID.randomUUID().toString();

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> students = (List<Map<String, Object>>) context.get("students");

        List<Students> studentsList = new ArrayList<>();
        for (Map<String, Object> data : students) {
            Students student = Students.create();
            student.setAdmissionNo((String) data.get("admissionNo"));
            student.setFullName((String) data.get("fullName"));
            student.setPhone((String) data.get("phone"));
            student.setParentPhone((String) data.get("parentPhone"));
            if (data.containsKey("branch_ID")) {
                student.setBranchId((String) data.get("branch_ID"));
            }
            studentsList.add(student);
        }

        processInsertInParallel(jobId, studentsList);

        context.put("jobId", jobId);
        context.put("status", "ACCEPTED");
        context.put("message", "Inserting " + studentsList.size() + " records in background");
        context.put("totalRecords", studentsList.size());
    }

    @On
    public void bulkUpdateStudents(EventContext context) {
        if (!"bulkUpdateStudents".equals(context.getEvent())) {
            return;
        }
        String jobId = UUID.randomUUID().toString();

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> students = (List<Map<String, Object>>) context.get("students");


        List<Students> studentsList = new ArrayList<>();
        for (Map<String, Object> data : students) {
            Students student = Students.create();
            student.setId((String) data.get("ID"));
            if (data.containsKey("admissionNo")) {
                student.setAdmissionNo((String) data.get("admissionNo"));
            }
            if (data.containsKey("fullName")) {
                student.setFullName((String) data.get("fullName"));
            }
            if (data.containsKey("phone")) {
                student.setPhone((String) data.get("phone"));
            }
            if (data.containsKey("parentPhone")) {
                student.setParentPhone((String) data.get("parentPhone"));
            }
            if (data.containsKey("branch_ID")) {
                student.setBranchId((String) data.get("branch_ID"));
            }
            studentsList.add(student);
        }

        processUpdateInParallel(jobId, studentsList);

        context.put("jobId", jobId);
        context.put("status", "ACCEPTED");
        context.put("message", "Updating " + studentsList.size() + " records in background");
        context.put("totalRecords", studentsList.size());
    }

    @Async
    public void processInsertInParallel(String jobId, List<Students> students) {
        log.info("Job {} - Started INSERT processing {} records", jobId, students.size());
        Instant start = Instant.now();

        try {
            List<List<Students>> chunks = partitionList(students, CHUNK_SIZE);
            log.info("Job {} - Split into {} chunks for INSERT", jobId, chunks.size());

            ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
            List<Future<ChunkResult>> futures = new ArrayList<>();

            for (List<Students> chunk : chunks) {
                Future<ChunkResult> future = executor.submit(() -> processInsertChunk(jobId, chunk));
                futures.add(future);
            }

            int totalProcessed = 0;
            int totalFailed = 0;

            for (Future<ChunkResult> future : futures) {
                try {
                    ChunkResult result = future.get();
                    totalProcessed += result.processed;
                    totalFailed += result.failed;
                } catch (Exception e) {
                    log.error("Job {} - Future failed: {}", jobId, e.getMessage());
                }
            }

            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.MINUTES);

            long durationMs = Instant.now().toEpochMilli() - start.toEpochMilli();
            log.info("Job {} INSERT COMPLETED | Total: {} | Success: {} | Failed: {} | Time: {} ms",
                    jobId, students.size(), totalProcessed, totalFailed, durationMs);

        } catch (Exception e) {
            log.error("Job {} INSERT FAILED: {}", jobId, e.getMessage(), e);
        }
    }

    @Async
    public void processUpdateInParallel(String jobId, List<Students> students) {
        log.info("Job {} - Started UPDATE processing {} records", jobId, students.size());
        Instant start = Instant.now();

        try {
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
            List<Future<Boolean>> futures = new ArrayList<>();

            for (Students student : students) {
                Future<Boolean> future = executor.submit(() -> processUpdateSingle(jobId, student));
                futures.add(future);
            }

            int totalProcessed = 0;
            int totalFailed = 0;

            for (Future<Boolean> future : futures) {
                try {
                    if (future.get()) {
                        totalProcessed++;
                    } else {
                        totalFailed++;
                    }
                } catch (Exception e) {
                    totalFailed++;
                    log.error("Job {} - Update future failed: {}", jobId, e.getMessage());
                }
            }

            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.MINUTES);

            long durationMs = Instant.now().toEpochMilli() - start.toEpochMilli();
            log.info("Job {} UPDATE COMPLETED | Total: {} | Success: {} | Failed: {} | Time: {} ms",
                    jobId, students.size(), totalProcessed, totalFailed, durationMs);

        } catch (Exception e) {
            log.error("Job {} UPDATE FAILED: {}", jobId, e.getMessage(), e);
        }
    }

    private ChunkResult processInsertChunk(String jobId, List<Students> chunk) {
        String threadName = Thread.currentThread().getName();
        log.debug("Job {} - Inserting {} records on thread {}", jobId, chunk.size(), threadName);

        ChunkResult result = new ChunkResult();

        try {
            List<List<Students>> batches = partitionList(chunk, 50);

            for (List<Students> batch : batches) {
                try {
                    studentRepository.insertStudents(batch);
                    result.processed += batch.size();
                } catch (Exception e) {
                    result.failed += batch.size();
                    log.error("Job {} - Insert batch failed on {}: {}", jobId, threadName, e.getMessage());
                }
            }

        } catch (Exception e) {
            result.failed += chunk.size();
            log.error("Job {} - Insert chunk failed on {}: {}", jobId, threadName, e.getMessage());
        }

        return result;
    }

    private Boolean processUpdateSingle(String jobId, Students student) {
        String threadName = Thread.currentThread().getName();

        try {
            studentRepository.updateStudent(student);
            log.trace("Job {} - Updated student {} on thread {}", jobId, student.getId(), threadName);
            return true;
        } catch (Exception e) {
            log.error("Job {} - Update failed for student {} on {}: {}",
                    jobId, student.getId(), threadName, e.getMessage());
            return false;
        }
    }

    private <T> List<List<T>> partitionList(List<T> list, int chunkSize) {
        List<List<T>> partitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            partitions.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return partitions;
    }

    private static class ChunkResult {
        int processed = 0;
        int failed = 0;
    }
}