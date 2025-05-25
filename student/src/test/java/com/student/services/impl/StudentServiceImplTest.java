package com.student.services.impl;
import com.student.entities.Student;
import com.student.repository.StudentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceImplTest {
    @Mock
    public StudentRepository studentRepository;

    @InjectMocks
    public StudentServiceImpl studentService;

    @Mock
    public Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setId(123L);
        student.setName("rajesh");
        student.setEmail("rajesh@gmail.com");
        student.setContactNumber("9988776655");
        student.setLocation("pune");
    }

    @Test
    void testFuncForSum(){
        assertEquals(10,studentService.justForTest());
        }

    @Test
    void testSaveStudent() {
        when(studentRepository.save(student)).thenReturn(student);

        Student student1 = studentService.create(student);
        assertNotNull(student1);
        assertEquals("rajesh", student1.getName());
    }

    @Test
    void testGetAllStudent() {
        List<Student> studentslist=new ArrayList<>();
        studentslist.add(new Student(112L,"ashok1","ashok1@gmail.com","99876454","Indore"));
        studentslist.add(new Student(112L,"ashok2","ashok1@gmail.com","99876454","Indore"));

        when(studentRepository.findAll()).thenReturn(studentslist);
        //List<Student>  list = studentRepository.findAll();
        List<Student>  list = studentService.getAllStudent();

        Student student1 = list.get(0);
        assertNotNull(student1);
        assertEquals("ashok1",student1.getName());
        //Assert.assertEquals(10,100);
    }
}
