package com.aleedev.SecuityCheck.Model;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Data
@Document (collection = "Contactus")
public class ContactUs {
    @Id
    private ObjectId id;

//    @NonNull
    private String name;
    private String email;
    private String desc;
    private String postedby;
    private String date;


}
