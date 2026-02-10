namespace coaching;

using {
  coaching.Batches,
  coaching.Subjects
} from './branch-model';
using { cuid, managed } from '@sap/cds/common';


entity Teachers : cuid, managed {
    empCode            : String(12);
    fullName           : String(90);
    phone              : String(15);
    email              : String(120);
    joiningDate        : Date;
    active             : Boolean default true;
    to_subjects        : Composition of many TeacherSubjects
                             on to_subjects.teacher = $self;
    to_batches         : Composition of many TeacherBatchAssignments
                             on to_batches.teacher = $self;
}

entity TeacherSubjects : cuid, managed {
    teacher            : Association to Teachers;
    subject            : Association to Subjects;
}

entity TeacherBatchAssignments : cuid, managed {
    teacher            : Association to Teachers;
    batch              : Association to Batches;
    role               : String(30) default 'main';
    assignedOn         : Date;
}
