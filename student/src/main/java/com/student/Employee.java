package com.student;
import java.util.List;

public class Employee {
    int empId;
    int empSalary;
    String empDept;
    String empLocation;
    public Employee(){

    }
    public Employee(int empId, int empSalary, String empDept, String empLocation) {
        this.empId = empId;
        this.empSalary = empSalary;
        this.empDept = empDept;
        this.empLocation = empLocation;
        /* // Write a program to shuffle the int array {1,2,12,0,3,0,5,6,7,0,9,0}
        // such that all the zero's are brought in the front of the array -->
        // {0,0,0,0,1,2,12,3,5,6,7,9}*/

        /*    List<Employee> list;
    //  List<Employee> updatedList=  list.stream().filter(employee -> employee.getEmpDept().equals("Delhi")).toList();

        Map<String,List<String>> map=list.stream().collect(Collectors.groupingBy(employee -> employee.getEmpDept(),Collectors.toList()));

        //Employee-->id,name,department_id,department_name
        //Department-> depart_id,department_name

        // update  Employee set department_name where         select department_name from department
*/
    }
    public int getEmpId() {
        return empId;
    }
    public int getEmpSalary() {
        return empSalary;
    }
    public String getEmpLocation() {
        return empLocation;
    }
    public void setEmpSalary(int empSalary) {
        this.empSalary=empSalary;
    }
    public String getEmpDept() {
        return empDept;
    }

    public static void main(String args[]) {
        Employee emp1 = new Employee(101, 5000, "IT","Delhi");
        Employee emp2 = new Employee(102, 7000,"IT","Pune");
        Employee emp3 = new Employee(103, 8000,"Finance","Pune");
        Employee emp4 = new Employee(104, 9000,"Finance","delhi");
        Employee emp5 = new Employee(105, 3000,"IT","indore");
        List<Employee> myList = List.of(emp1,emp2,emp3,emp4,emp5);
    }
}



