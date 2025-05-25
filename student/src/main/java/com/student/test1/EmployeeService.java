package com.student.test1;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
   static List<EmployeeBeen> employeeBeenList;
    static {
        employeeBeenList=new ArrayList<>();
      //String name, String department, int salary
        employeeBeenList.add(new EmployeeBeen(11,"AA","hr",5000));
        employeeBeenList.add(new EmployeeBeen(22,"BB","Davelepment",5000));
    }
    public EmployeeBeen saveData(EmployeeBeen employeeBeen){
        employeeBeenList.add(employeeBeen);
        return employeeBeen;
    }

    public List<EmployeeBeen> getAllData(){
        return employeeBeenList;
    }

    public EmployeeBeen getData(int id){
        employeeBeenList.stream().sorted((o1, o2) -> o2.getSalary()-o1.getSalary())
                .limit(1).forEach(employeeBeen -> System.out.println(employeeBeen.getSalary()));


        EmployeeBeen employeeBeen=null;
        for (int i=0;i<employeeBeenList.size();i++){
            if (id==employeeBeenList.get(i).getId()){
                employeeBeen=employeeBeenList.get(i);
            }

        }
        return employeeBeen;
    }

}
