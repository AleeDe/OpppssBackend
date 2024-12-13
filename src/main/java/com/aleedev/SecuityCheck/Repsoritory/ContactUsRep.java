package com.aleedev.SecuityCheck.Repsoritory;

import com.aleedev.SecuityCheck.Model.ContactUs;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactUsRep extends MongoRepository<ContactUs, ObjectId> {
}
