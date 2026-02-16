using coaching as db from '../db/teacher-model';

service TeacherService {
    entity Teachers as projection on db.Teachers;
    entity TeacherSubjects as projection on db.TeacherSubjects;
    entity TeacherBatchAssignments as projection on db.TeacherBatchAssignments;
}