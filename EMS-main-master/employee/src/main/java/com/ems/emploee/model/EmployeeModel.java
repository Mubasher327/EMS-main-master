package com.ems.emploee.model;
import com.ems.emploee.entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class EmployeeModel {
    private long id;
    private String fullName;
    private String email;
    private String phoneNo;
    private String gender;
    private int age;
    private String designation;
    private double salary;
    private DepartmentModel departmentModel;

    public EmployeeModel(Employee employee){
        this.setId(employee.getId());
        this.setFullName(employee.getFullName());
        this.setEmail(employee.getEmail());
        this.setPhoneNo(employee.getPhoneNo());
        this.setGender(employee.getGender());
        this.setAge(employee.getAge());
        this.setDesignation(employee.getDesignation());
        this.setSalary(employee.getSalary());
        this.setDepartmentModel(new DepartmentModel(employee.getDepartment()));
    }


    public Employee dissamble(){

    Employee employee=new Employee();
    employee.setId(id);
    employee.setFullName(fullName);
    employee.setEmail(email);
    employee.setPhoneNo(phoneNo);
    employee.setGender(gender);
    employee.setAge(age);
    employee.setDesignation(designation);
    employee.setSalary(salary);
    employee.setDepartment(this.departmentModel.dissamble());

    return employee;
}

public EmployeeModel assemble(Employee employee){

    EmployeeModel employeeModel=new EmployeeModel(null);
    DepartmentModel departmentModel1=new DepartmentModel(null);

    employeeModel.setId(employee.getId());
    employeeModel.setFullName(employee.getFullName());
    employeeModel.setEmail(employee.getEmail());
    employeeModel.setPhoneNo(employee.getPhoneNo());
    employeeModel.setGender(employee.getGender());
    employeeModel.setAge(employee.getAge());
    employeeModel.setDesignation(employee.getDesignation());
    employeeModel.setSalary(employee.getSalary());
    employeeModel.setDepartmentModel(departmentModel1.assemble(employee.getDepartment()));

    return employeeModel;
    }
}

