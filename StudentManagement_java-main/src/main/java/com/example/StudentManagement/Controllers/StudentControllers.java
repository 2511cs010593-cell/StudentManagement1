package com.example.StudentManagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Repository.StudentRepository;
@CrossOrigin(origins = "*")
@RestController
public class StudentControllers {
     @Autowired
     StudentRepository repo;
     // get request
     @GetMapping("/student")
     public List<Student> getALlStudents(){
          return repo.findAll();
     }
     @PostMapping("/student")
     public String createStudent(@RequestBody Student student){
          repo.save(student);
          return "New Student data add successfully";
          
     }
     @GetMapping("/student/{id}")
     public Student getStudentById(@PathVariable Integer id){
          return repo.findById(id)
          .orElseThrow(() -> new RuntimeException("Student data not found with id:"+id));
     }
     @DeleteMapping("/student/{id}")
     public String deleteStudentByID(@PathVariable int id){
          repo.deleteById(id);
          return "Student is deleted with id: "+id;
     }
     @PutMapping("/student/{id}")
     public Student updateStudent(@PathVariable int id,@RequestBody Student updateData){
          return repo.findById(id)
          .map(data -> {
               data.setName(updateData.getName());
               data.setAge(updateData.getAge());
                return repo.save(data);
                
          }).orElseThrow(() -> new RuntimeException("Unable to update data"));
     }

}
