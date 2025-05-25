package com.student.controllers;
import com.student.entities.Student;
import com.student.services.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


//@WebMvcTest(StudentController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private StudentService studentService;

    @BeforeEach
    public void init() {
        //Initialize any data or mocks if needed
    }

    @AfterEach
    public void cleanup() {
        // Clean up resources or reset mocks if necessary
    }

    @Test
    public void test_create_student_success() throws Exception {
        // Prepare mock data
        Student newStudent = new Student(1L, "Jane Doe", "9988776655", "jane@example.com", "indore");
        Student createdStudent = new Student(2L, "Jane Doe", "9988776655", "jane@example.com", "indore");

        // Mock the service layer
        Mockito.when(studentService.create(Mockito.any(Student.class))).thenReturn(createdStudent);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Jane Doe\",\n" +
                                "    \"contactNumber\": \"9988776655\",\n" +
                                "    \"email\": \"jane@example.com\",\n" +
                                "    \"location\": \"indore\"\n" +
                                "}"))
                .andExpect(status().isCreated()) // Expect HTTP 201
                .andExpect(jsonPath("$.name").value("Jane Doe"))
                .andExpect(jsonPath("$.contactNumber").value("9988776655"))
                .andExpect(jsonPath("$.email").value("jane@example.com"))
                .andExpect(jsonPath("$.location").value("indore"));
    }
}
