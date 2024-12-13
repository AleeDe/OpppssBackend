package com.aleedev.SecuityCheck.Controller;

import com.aleedev.SecuityCheck.Model.Resource;
import com.aleedev.SecuityCheck.Service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = "https://campus-connect-hazel.vercel.app/")
public class ResourceController {

    @Autowired
    private ResourcesService resourcesService;

    @PostMapping
    public ResponseEntity<Resource> saveResources(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("subject") String subject,
            @RequestParam("semester") String semester,
            @RequestParam("postedby") String postedby) {
        try {
            Resource resource = new Resource();
            resource.setTitle(title);
            resource.setDescription(description);
            resource.setSubject(subject);
            resource.setSemester(semester);
            resource.setPostedby(postedby);

            Resource savedResource = resourcesService.postResource(resource, files);
            return new ResponseEntity<>(savedResource, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResource() {
        return new ResponseEntity<>(resourcesService.getAllResource(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable String id) {
        resourcesService.deleteResource(id);
        return new ResponseEntity<>("Resource deleted successfully", HttpStatus.NO_CONTENT);
    }
}
