package com.js.lab7.services;

import com.js.lab7.entities.Student;
import com.js.lab7.entities.StudentRepository;
import com.js.lab7.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentList() {
        return (List<Student>) studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Optional<Student> probablyStudent = studentRepository.findById(id);
        if (probablyStudent.isPresent()) {
            studentRepository.delete(probablyStudent.get());
        } else throw new StudentNotFoundException(id);
    }

//    public void editStudentData(Student student,Long id) {
//        Optional<Student> probablyStudent = studentRepository.findById(id);
//        if (probablyStudent.isPresent()) {
//            probablyStudent.get().setName(student.getName());
//            probablyStudent.get().setSurname(student.getSurname());
//            probablyStudent.get().setAverage(student.getAverage());
//            studentRepository.save(probablyStudent.get());
//        } else throw new StudentNotFoundException(id);
//    }
public void editStudentData(Student student) {
        Optional<Student> probablyStudent = studentRepository.findStudentById(student.getId());
        if (probablyStudent.isPresent()) {
            probablyStudent.get().setName(student.getName());
            probablyStudent.get().setSurname(student.getSurname());
            probablyStudent.get().setAverage(student.getAverage());
            studentRepository.save(probablyStudent.get());
        } else throw new StudentNotFoundException(student.getId());
    }
}


