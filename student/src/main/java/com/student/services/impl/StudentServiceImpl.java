package com.student.services.impl;
import com.student.entities.Student;
import com.student.repository.StudentRepository;
import com.student.services.StudentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
//@Scope("prototype")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public int justForTest() {
        return sum();
    }

    private int sum() {
        return 10;
    }

    @PostConstruct
    public void inIt() {
        //it use for initialize value
        a = 100;
    }

    @PreDestroy
    public void onDestroy() {
        //it use Clean up the code it will called just before object destroy
        a = 0;
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    int a = 0;

    @Override
    public List<Student> getAllStudent() {
        System.out.println(a);
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByName(String name) {
        System.out.println(name);
        List<Student> students = studentRepository.getUserDataByName(name);
        System.out.println(students);
        return students;
    }
    @Override
    public List<Student> getStudentByContactNumber(String contactNumber) {
        return studentRepository.getStudentByPhone(contactNumber);
    }
    @Override
    public List<Student> searchStudentByName(String name) {
        System.out.println(name);
        return studentRepository.searchUserByName(name);
    }
    public List<Student> getDataByPage(Integer page) {
        int pageNumber = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "CreateAt");
        return studentRepository.findAll(pageable).getContent();
    }
    @Override
    public Student updateStudent(long id) {
        return null;
    }

    @Override
    public Student updateSpecificField(long id, Student student) {
       Student existingStudent = studentRepository.findById(id).orElse(student);
       if (existingStudent==null){
           return existingStudent;
       }

        if(student.getName() != null) {
            existingStudent.setName(student.getName());
        }

        Student student1 = studentRepository.save(existingStudent);
        return student1;
    }
}
