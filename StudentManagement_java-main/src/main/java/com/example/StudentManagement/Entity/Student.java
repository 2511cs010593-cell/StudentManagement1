package com.example.StudentManagement.Entity;
import org.springframework.data.mapping.AccessOptions.GetOptions.GetNulls;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     private String name;
     private int age;
     public Student() {
     }
     public Student(String name, int age) {
          this.name = name;
          this.age = age;
     }
     public Integer getId() {
          return id;
     }
     public String getName() {
          return name;
     }
     public int getAge() {
          return age;
     }
     public void setId(Integer id) {
          this.id = id;
     }
     public void setName(String name) {
          this.name = name;
     }
     public void setAge(int age) {
          this.age = age;
     }
     



}
