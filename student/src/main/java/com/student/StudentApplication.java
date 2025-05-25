package com.student;
import com.student.test.MyFunctional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
        System.out.println("hello..........");

        MyFunctional myFunctional=(aa,bb)->{
            int c=aa+bb;
            return c;
        };

        System.out.println(myFunctional.save(11,33));
        myFunctional.sum1();
        myFunctional.sum2();

        MyFunctional.sum22();
        MyFunctional.sum33();


    }
}
