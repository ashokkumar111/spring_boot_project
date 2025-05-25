package com.student.services;
import com.student.entities.Student;
import java.util.List;
public interface StudentServiceTest {
    Student create(Student student);

    //get all Student
    List<Student> getAllStudent();
}
