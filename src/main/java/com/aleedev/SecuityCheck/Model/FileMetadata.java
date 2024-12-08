package com.aleedev.SecuityCheck.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FileMetadata {
    private String header;
    private String name;
    private byte[] data;
}
