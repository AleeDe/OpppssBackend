package com.aleedev.SecuityCheck.Model;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class Users {
    @Id
    private ObjectId id;

    private String stringId;


//    @NonNull
    private String email;

    @NonNull
    private String name;
    @NonNull
    private String password;

    public String getStringId() {
        return id != null ? id.toHexString() : null;
    }
}
