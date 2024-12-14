package com.aleedev.SecuityCheck.Controller;

import com.aleedev.SecuityCheck.Model.JIPost;
import com.aleedev.SecuityCheck.Model.Student;
import com.aleedev.SecuityCheck.Service.JIPostServices;
import com.aleedev.SecuityCheck.Service.StudentServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://54.221.19.62:3000/")
public class JIpostController {

    @Autowired
    JIPostServices jiPostServices;

    @PostMapping("/jiPost")
    public ResponseEntity<?> createStudent(@RequestBody JIPost jiPost){
        return new ResponseEntity<>(jiPostServices.saveJIPost(jiPost), HttpStatus.CREATED);
    }



    @GetMapping("/jiPost")
    public ResponseEntity<?> getStudent(){
        return new ResponseEntity<>(jiPostServices.getAllStudent(), HttpStatus.OK);
    }

    @PutMapping("/jiPost/{id}")
    public ResponseEntity<?> updateJIPost(@PathVariable String id, @RequestBody JIPost jiPost) {
        JIPost updatedJIPost = jiPostServices.updateJIPost(id, jiPost);
        if (updatedJIPost != null) {
            return new ResponseEntity<>(updatedJIPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/jiPost/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        boolean isDeleted = jiPostServices.deleteJIPost(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
    }
}
