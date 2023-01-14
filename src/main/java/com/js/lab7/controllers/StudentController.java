package com.js.lab7.controllers;

import com.js.lab7.entities.Student;
import com.js.lab7.exceptions.StudentNotFoundException;
import com.js.lab7.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;


    @CrossOrigin("http://localhost:63342")
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll(){
        studentService.getStudentList();
        return ResponseEntity.ok().body(studentService.getStudentList());
}

    @CrossOrigin("http://localhost:63342")
    @PostMapping("/students/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok().body("Student został dodany");
    }

    @CrossOrigin("http://localhost:63342")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().body("Student został usunięty");
        }catch (StudentNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

    }

    @CrossOrigin("http://localhost:63342")
    @PutMapping("/students/edit/{id}")
    public ResponseEntity<String> editStudentData(@PathVariable Long id, @RequestBody Student student){
        try {
            studentService.editStudentData(student,id);
            return ResponseEntity.ok().body("Student zaktualizowany");
        }catch (StudentNotFoundException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

}
