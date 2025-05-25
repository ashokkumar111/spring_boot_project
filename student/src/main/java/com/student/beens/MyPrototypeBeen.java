package com.student.beens;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")  //This ensures a new instance every time
public class MyPrototypeBeen {
    private String message;

    public MyPrototypeBeen() {
        this.message = "Prototype Bean Instance Created!";
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
  }
