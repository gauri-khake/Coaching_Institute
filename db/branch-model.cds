namespace coaching;

using { cuid, managed } from '@sap/cds/common';

entity Branches : cuid, managed {
    branchCode         : String(10);
    name               : String(80);
    city               : String(60);
    active             : Boolean default true;
    to_batches         : Composition of many Batches
                             on to_batches.branch = $self;
}

entity Courses : cuid, managed {
    courseCode         : String(12);
    name               : String(100);
    targetExam         : String(50);
    durationMonths     : Integer;
    totalFees          : Decimal(10,2);
    to_batches         : Composition of many Batches
                            on to_batches.course = $self;
}

entity Subjects : cuid, managed {
    code               : String(10);
    name               : String(80);
}

entity Batches : cuid, managed {
    batchCode          : String(20);
    startDate          : Date;
    timing             : String(50);
    maxStrength        : Integer default 60;
    branch             : Association to Branches;
    course             : Association to Courses;
}
