using coaching as db from '../db/branch-model';

service BatchService {
    entity Batches as projection on db.Batches;
}