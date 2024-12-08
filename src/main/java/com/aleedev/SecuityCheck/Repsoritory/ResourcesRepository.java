package com.aleedev.SecuityCheck.Repsoritory;

import com.aleedev.SecuityCheck.Model.Resource;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourcesRepository extends MongoRepository<Resource, ObjectId> {
    Resource deleteBystringId(String stringId);
}
