  using coaching as db from '../db/students-model';

  service StudentService {
      entity Students as projection on db.Students;

      action bulkInsertStudents(students : array of {
              admissionNo: String;
              fullName: String;
              phone: String;
              parentPhone: String;
              branch_ID: String;
          });

          action bulkUpdateStudents(students : array of {
              ID: String;
              admissionNo: String;
              fullName: String;
              phone: String;
              parentPhone: String;
              branch_ID: String;
          });
  }