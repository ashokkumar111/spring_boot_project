package com.student.services;
import com.student.entities.Student;
import java.util.List;
public interface StudentService {
    //create student
    Student create(Student student);
    //get all Student
    List<Student> getAllStudent();

    List<Student> getByName(String name);

   List<Student> getStudentByContactNumber(String mobile);
   List<Student> searchStudentByName(String name);

   Student updateStudent(long id);

   Student updateSpecificField(long id,Student student);
}
