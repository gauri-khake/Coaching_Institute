using coaching as db from '../db/schema';

service CoachingService {
    entity Students as projection on db.Students;
    entity Branches as projection on db.Branches;
    entity Batches as projection on db.Batches;
    entity Enrollments as projection on db.Enrollments;
    entity Teachers as projection on db.Teachers;
    entity Courses as projection on db.Courses;
    entity Subjects as projection on db.Subjects;
    entity FeePayments as projection on db.FeePayments;
    entity TeacherSubjects as projection on db.TeacherSubjects;
    entity TeacherBatchAssignments as projection on db.TeacherBatchAssignments;
}
