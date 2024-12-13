package com.aleedev.SecuityCheck.Controller;

import com.aleedev.SecuityCheck.Model.Users;
import com.aleedev.SecuityCheck.Service.UserServices;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://campus-connect-hazel-rose.vercel.app/")
@RestController
public class userController {
    @Autowired
    UserServices userServices;

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody Users users){
        return new ResponseEntity<>(userServices.saveUser(users), HttpStatus.CREATED);
    }
    @PostMapping("/log")
    public ResponseEntity<?> login(@RequestBody Users users){

        return new ResponseEntity<>(userServices.verify(users),HttpStatus.OK);
    }


}
