package com.aleedev.SecuityCheck.Service;

import com.aleedev.SecuityCheck.Model.FileMetadata;
import com.aleedev.SecuityCheck.Model.Resource;
import com.aleedev.SecuityCheck.Repsoritory.ResourcesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ResourcesService {

    @Autowired
    private ResourcesRepository resourcesRepository;

    // Method to post a resource with file metadata
    public Resource postResource(Resource resource,MultipartFile[] files) throws IOException {
        List<FileMetadata> fileMetadataList = new ArrayList<>();

        // Process each file and create FileMetadata objects
        for (MultipartFile file : files) {
            FileMetadata fileMetadata = new FileMetadata();
            fileMetadata.setName(file.getOriginalFilename());
            fileMetadata.setData(file.getBytes());
//            fileMetadata.setHeader(file.getContentType()); // Ensure header is set correctly
            fileMetadataList.add(fileMetadata);
        }

        // Create a new Resource object and set its properties
        resource.setFiles(fileMetadataList);

        // Save the Resource object to the repository
        return resourcesRepository.save(resource);
    }

    // Method to get all resources
    public ArrayList<Resource> getAllResource() {
        return (ArrayList<Resource>) resourcesRepository.findAll();
    }

    // Method to delete a resource by ID
    public String deleteResource(String id) {
        ObjectId objectId = new ObjectId(id);
        resourcesRepository.deleteById(objectId);
        return "True";
    }
}
