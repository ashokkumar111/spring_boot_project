package com.student.test1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/data/{id}")
    public EmployeeBeen getDataById(@PathVariable("id") int empId){
       return employeeService.getData(empId);
    }
    @GetMapping("/data")
    public List<EmployeeBeen> getAllData(){
        return employeeService.getAllData();
    }
    @PostMapping("/save_data")
    public EmployeeBeen saveData(@RequestBody EmployeeBeen employeeBeen){

        return employeeService.saveData(employeeBeen);
    }
}
