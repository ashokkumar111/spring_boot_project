package com.student.test;
import com.student.entities.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyPractice {

    public static void main(String[] args) {
        List<Student> studentList=new ArrayList<>();
        Student student=new Student();
        student.setId(11L);
        student.setName("Ashok");
        student.setEmail("ashok@gmail.com");
        student.setLocation("Indore");
        student.setContactNumber("9988776655");
        studentList.add(student);

        List<Student> studentList11=new ArrayList<>();
        Student student11=new Student();
        student11.setId(12L);
        student11.setName("Rahul");
        student11.setEmail("rahul@gmail.com");
        student11.setLocation("Indore");
        student11.setContactNumber("888888876666");
        studentList11.add(student11);

        List<Student> studentList22=new ArrayList<>();
        Student student22=new Student();
        student22.setId(13L);
        student22.setName("brajendra");
        student22.setEmail("brajendra@gmail.com");
        student22.setLocation("bhopal");
        student22.setContactNumber("55543434");
        studentList22.add(student22);

        List<List<Student>> flatStudentList=List.of(studentList,studentList11,studentList22);

        List<Student> studentList11111 = flatStudentList.stream()
              .flatMap(Collection::stream).collect(Collectors.toList());

        studentList11111.forEach(stu -> {
            System.out.println("name: "+stu.getName() +" Location"+stu.getLocation());
                });
        }
}
