package com.aleedev.SecuityCheck.Repsoritory;

import com.aleedev.SecuityCheck.Model.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users, ObjectId> {
     Users findByName(String name);
}
