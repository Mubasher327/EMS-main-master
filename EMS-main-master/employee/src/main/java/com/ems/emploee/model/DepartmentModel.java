package com.ems.emploee.model;

import com.ems.emploee.entity.Department;
import com.ems.emploee.entity.Employee;
import com.ems.emploee.services.RegisteredEmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Data
public class DepartmentModel {
    int id;
    private String name;
    private String description;


    public Department dissamble(){
        Department department=new Department();

        department.setName(name);
        department.setId(id);
        department.setDescription(description);



        return department;
    }

    public DepartmentModel assemble(Department department){

        DepartmentModel departmentModel=new DepartmentModel();
        departmentModel.setId(department.getId());
        departmentModel.setName(department.getName());
        departmentModel.setDescription(department.getDescription());


        return departmentModel;
    }
}

