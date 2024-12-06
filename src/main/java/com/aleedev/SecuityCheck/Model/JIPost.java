package com.aleedev.SecuityCheck.Model;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Job/Intership_Post")
public class JIPost {
    @Id
    private ObjectId id;

    private String stringId; // Transient field for frontend use

    @NonNull
    private String formTitle;
    private String title;
    private String desc;
    private String postedby;

    public String getStringId() {
        return id != null ? id.toHexString() : null;
    }

}
