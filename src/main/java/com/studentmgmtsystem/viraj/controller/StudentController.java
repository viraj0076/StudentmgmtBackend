package com.studentmgmtsystem.viraj.controller;

import com.studentmgmtsystem.viraj.model.Student;
import com.studentmgmtsystem.viraj.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class StudentController {
    @Autowired
    StudentRepo studentRepo;
    @GetMapping("/listStudents")
    public List<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }
    @GetMapping("/student/{id}")
    public List<Student> studentById(@PathVariable Integer id)
    {
        return (List<Student>) studentRepo.findById(id).get();
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Integer id)
    {
        boolean studentExits = studentRepo.existsById(id);
        if(studentExits)
        {
            studentRepo.deleteById(id);
            return "Student Deleted SuccessFully";
        }
        else
        {
            return "The Student Id is not Exist";
        }
    }
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student)
    {
        boolean studentExits = studentRepo.existsById(student.getId());
        if(!studentExits)
        {
            studentRepo.save(student);
            return "Record Saved SuccessFully";
        }
        else
        {
            return "Record ALready Exits";
        }
    }
    @PutMapping("/student/{id}")
    public List<Student> updateStudent(@RequestBody Student student,@PathVariable Integer id)
    {
        Student studentObj = studentRepo.findById(id).get();
        studentObj.setName(student.getName());
        studentObj.setAddress(student.getAddress());
        studentRepo.save(student);
        return studentRepo.findAll();
    }

}
