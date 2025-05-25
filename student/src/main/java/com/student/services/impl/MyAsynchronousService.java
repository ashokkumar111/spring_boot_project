package com.student.services.impl;
import com.student.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;

@Service
public class MyAsynchronousService {

    @Autowired
    private RestTemplate restTemplate;

    public Employee getDataFromParallelCall(String userId) {
        Employee employee = new Employee();

        CompletableFuture.allOf(
                CompletableFuture.supplyAsync(() -> restTemplate.exchange("http://localhost:8080/user/" + userId, HttpMethod.GET, null, String.class)).thenAccept(data -> employee.setEmpSalary(12)),
                CompletableFuture.supplyAsync(() -> restTemplate.exchange("url2" + userId, HttpMethod.GET, null, String.class)).thenAccept(data -> employee.setEmpSalary(13)),
                CompletableFuture.supplyAsync(() -> restTemplate.exchange("url3" + userId, HttpMethod.GET, null, String.class)).thenAccept(data -> employee.setEmpSalary(14))
        ).join();

        return employee;
    }
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }

}
