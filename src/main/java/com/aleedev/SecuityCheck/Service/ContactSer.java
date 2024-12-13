package com.aleedev.SecuityCheck.Service;

import com.aleedev.SecuityCheck.Model.ContactUs;
import com.aleedev.SecuityCheck.Model.JIPost;
import com.aleedev.SecuityCheck.Repsoritory.ContactUsRep;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ContactSer {
    @Autowired
    ContactUsRep contactUsRep;
    public ContactUs saveJIPost(ContactUs contactUs) {
        return contactUsRep.save(contactUs);
    }
}
