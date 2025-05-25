package com.student.controllers;
import com.student.Employee;
import com.student.beens.MyPrototypeBeen;
import com.student.entities.Student;
import com.student.services.StudentService;
import com.student.services.impl.MyAsynchronousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")     //this Context path can config in application.properties file as well.
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private MyPrototypeBeen myPrototypeBeen;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.create(student);

        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList=studentService.getAllStudent();
      return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
    @GetMapping("/user/{name}")
    public ResponseEntity<List<Student>> getByName(@PathVariable("name") String name1){
      return new ResponseEntity<>(studentService.getByName(name1),HttpStatus.OK);
    }
    @GetMapping("/{contact_number}")
    public List<Student> getStudentByContactNumberFunc(@PathVariable("contact_number") String mobile){
        return studentService.getStudentByContactNumber(mobile.trim());
    }
    @GetMapping("/search/{name}")
    public List<Student> searchStudentByName(@PathVariable("name") String searchData){
        return studentService.searchStudentByName(searchData);
    }
    @GetMapping("/test")
    public String PrototypeBeenFunc(){
       String msg = myPrototypeBeen.getMessage();
       return msg;
    }
    @PutMapping("/{id}")
    public String updateData(@PathVariable("id") Long studentId) {
           studentService.updateStudent(studentId);
        return "Update successfully";
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateSpecificField(@PathVariable Long id, @RequestBody Student student){
        System.out.println("Patch method..."+student);
        Student student1= studentService.updateSpecificField(id,student);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("key","Ashok Kumar Kushwaha");

        return new ResponseEntity<Student>(student1,httpHeaders,HttpStatus.CREATED);
    }
    @GetMapping("/my_test")
    public ResponseEntity<Integer> getDataFunc(){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("test_key1","Ashok kumar");
        httpHeaders.add("test_key2","Ashok kumar");
        httpHeaders.add("test_key3","Ashok kumar");
        httpHeaders.add("test_key4","Ashok kumar");

        Employee emp1 = new Employee(101, 5000, "IT","Delhi");
        Employee emp2 = new Employee(102, 7000,"IT","Pune");
        Employee emp3 = new Employee(103, 8000,"Finance","Pune");
        Employee emp4 = new Employee(104, 9000,"Finance","delhi");
        Employee emp5 = new Employee(105, 3000,"IT","indore");
        List<Employee> list=List.of(emp1,emp2,emp3,emp4,emp5);
        return new ResponseEntity(list, httpHeaders, HttpStatus.CREATED);
    }

    @Autowired
    private MyAsynchronousService myAsynchronousService;

    @PostMapping("/user_details")
    public ResponseEntity<Employee> getDataFromParallelCallApi(@PathVariable("id") String userId){
        Employee employee=myAsynchronousService.getDataFromParallelCall(userId);
      return ResponseEntity.ok(employee);
    }
}
