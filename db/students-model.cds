namespace coaching;

using { coaching.Branches } from './branch-model';
using { coaching.Enrollments } from './enrollment-model';
using { cuid, managed } from '@sap/cds/common';


entity Students : cuid, managed {
    admissionNo        : String(20);
    fullName           : String(90);
    phone              : String(15);
    parentPhone        : String(15);
    branch             : Association to Branches;
    to_enrollments     : Composition of many Enrollments
                             on to_enrollments.student = $self;
}
