package com.aleedev.SecuityCheck.Controller;

import com.aleedev.SecuityCheck.Model.ContactUs;
import com.aleedev.SecuityCheck.Service.ContactSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://18.212.118.7:3000/")
public class ContactUsController {
    @Autowired
    ContactSer contactSer;
    @PostMapping("contactus")
    public ResponseEntity<?> saveContact(ContactUs contactUs){
        
        return new ResponseEntity<>(contactSer.saveJIPost(contactUs), HttpStatus.CREATED);
    }
}
