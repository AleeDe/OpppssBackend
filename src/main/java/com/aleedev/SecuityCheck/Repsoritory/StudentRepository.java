package com.aleedev.SecuityCheck.Repsoritory;

import com.aleedev.SecuityCheck.Model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, ObjectId> {

}
