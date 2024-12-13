package com.aleedev.SecuityCheck.Controller;

import com.aleedev.SecuityCheck.Model.ContactUs;
import com.aleedev.SecuityCheck.Service.ContactSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactUsController {
    @Autowired
    ContactSer contactSer;
    @PostMapping("contactus")
    public ResponseEntity<?> saveContact(ContactUs contactUs){
        
        return new ResponseEntity<>(contactSer.saveJIPost(contactUs), HttpStatus.CREATED);
    }
}
