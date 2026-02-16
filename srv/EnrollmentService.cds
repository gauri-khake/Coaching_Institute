using coaching as db from '../db/enrollment-model';

service EnrollmentService {
    entity Enrollments as projection on db.Enrollments;
    entity FeePayments as projection on db.FeePayments;

}