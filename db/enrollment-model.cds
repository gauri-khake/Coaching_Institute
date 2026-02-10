namespace coaching;

using { coaching.Batches } from './branch-model';
using { coaching.Students } from './students-model';
using { cuid, managed } from '@sap/cds/common';


entity Enrollments : cuid, managed {
    student               : Association to Students;
    batch                 : Association to Batches;
    enrollDate            : Date;
    totalFees             : Decimal(10,2);
    finalFees             : Decimal(10,2);
    status                : String(20) default 'active';
    to_payments           : Composition of many FeePayments
                                on to_payments.enrollment = $self;
}

entity FeePayments : cuid, managed {
    enrollment            : Association to Enrollments;
    amount                : Decimal(10,2);
    paymentDate           : Date;
    mode                  : String(30);
    receiptNo             : String(20);
}
