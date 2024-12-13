package com.aleedev.SecuityCheck.Model;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Resources")
public class Resource {
    @Id
    private ObjectId id;
    private String stringId;
    private String title;

    @NonNull
    private String description;
    private List<FileMetadata> files;
    private String subject;
    private String semester;
    private String postedby;
    private String date;

    public String getStringId() {
        return id != null ? id.toHexString() : null;
    }

    public Resource() {
    }
}
