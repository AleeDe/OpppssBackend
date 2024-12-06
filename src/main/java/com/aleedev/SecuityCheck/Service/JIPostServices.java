package com.aleedev.SecuityCheck.Service;

import com.aleedev.SecuityCheck.Model.JIPost;
import com.aleedev.SecuityCheck.Model.Student;
import com.aleedev.SecuityCheck.Repsoritory.JIPostRepository;
import com.aleedev.SecuityCheck.Repsoritory.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class JIPostServices {

    @Autowired
    JIPostRepository jiPostRepository;

    public ArrayList<JIPost> getAllStudent() {
        ArrayList<JIPost> jiPosts = (ArrayList<JIPost>) jiPostRepository.findAll();
        jiPosts.forEach(jiPost -> jiPost.setStringId(jiPost.getId().toHexString()));
        return jiPosts;
    }

    public JIPost saveJIPost(JIPost jiPost) {
        jiPost.setId(ObjectId.get()); // Generate new ObjectId
        jiPost.setStringId(jiPost.getId().toHexString());
        return jiPostRepository.save(jiPost);
    }

    public JIPost updateJIPost(String id, JIPost jiPost) {
        Optional<JIPost> optionalStudent = jiPostRepository.findById(new ObjectId(id));
        if (optionalStudent.isPresent()) {
            JIPost existingJIPost = optionalStudent.get();
            existingJIPost.setTitle(jiPost.getTitle());
            existingJIPost.setFormTitle(jiPost.getFormTitle());
            existingJIPost.setDesc(jiPost.getDesc());
            existingJIPost.setStringId(existingJIPost.getId().toHexString());
            return jiPostRepository.save(existingJIPost);
        } else {
            return null;
        }
    }

    public boolean deleteJIPost(String id) {
        ObjectId objectId = new ObjectId(id);
        if (jiPostRepository.existsById(objectId)) {
            jiPostRepository.deleteById(objectId);
            return true;
        } else {
            return false;
        }
    }
}
