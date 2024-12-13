package com.aleedev.SecuityCheck.Controller;

import com.aleedev.SecuityCheck.Model.Student;
import com.aleedev.SecuityCheck.Service.StudentServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://campus-connect-hazel.vercel.app/")
public class studentController {

    @Autowired
    StudentServices studentServices;

    @PostMapping("/student")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentServices.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/token")
    public CsrfToken getCsrfToken(HttpServletRequest http){
        return (CsrfToken) http.getAttribute("_csrf");
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudent(){
        return new ResponseEntity<>(studentServices.getAllStudent(), HttpStatus.OK);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody Student student) {
        Student updatedStudent = studentServices.updateStudent(id, student);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        boolean isDeleted = studentServices.deleteStudent(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
}
