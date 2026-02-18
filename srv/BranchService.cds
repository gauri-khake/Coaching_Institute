using coaching as db from '../db/branch-model';

service BatchService {
    entity Batches as projection on db.Batches;
    entity Branches as projection on db.Branches;
    entity Courses as projection on db.Courses;
    entity Subjects as projection on db.Subjects;
}