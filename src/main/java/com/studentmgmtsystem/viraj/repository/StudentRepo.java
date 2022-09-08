package com.studentmgmtsystem.viraj.repository;

import com.studentmgmtsystem.viraj.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
//    List<Student> findAll(Student student);
}
