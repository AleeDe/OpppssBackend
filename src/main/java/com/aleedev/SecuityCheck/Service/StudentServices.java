package com.aleedev.SecuityCheck.Service;

import com.aleedev.SecuityCheck.Model.Student;
import com.aleedev.SecuityCheck.Repsoritory.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class StudentServices {

    @Autowired
    StudentRepository studentRepository;

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> students = (ArrayList<Student>) studentRepository.findAll();
        students.forEach(student -> student.setStringId(student.getId().toHexString()));
        return students;
    }

    public Student saveStudent(Student student) {
        student.setId(ObjectId.get()); // Generate new ObjectId
        student.setStringId(student.getId().toHexString());
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(new ObjectId(id));
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(studentDetails.getName());
            existingStudent.setMarks(studentDetails.getMarks());
            existingStudent.setStringId(existingStudent.getId().toHexString());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    public boolean deleteStudent(String id) {
        ObjectId objectId = new ObjectId(id);
        if (studentRepository.existsById(objectId)) {
            studentRepository.deleteById(objectId);
            return true;
        } else {
            return false;
        }
    }
}
