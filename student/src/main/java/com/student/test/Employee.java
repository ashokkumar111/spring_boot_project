package com.student.test;
public class Employee {
    private  String name;
    private int salary;
    private String gender;
    private String department;


    public Employee(String name, int salary, String gender, String department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
