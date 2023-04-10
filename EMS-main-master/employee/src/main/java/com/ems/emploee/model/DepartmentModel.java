package com.ems.emploee.model;

import com.ems.emploee.entity.Department;
import com.ems.emploee.entity.Employee;
import com.ems.emploee.services.RegisteredEmployeeService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
public class DepartmentModel {
    long id;
    private String name;
    private String description;

    public DepartmentModel(Department department){
        this.setId(department.getId());
        this.setName(department.getName());
        this.setDescription(department.getDescription());
    }
    public Department dissamble(){
        Department department=new Department();

        department.setName(name);
        department.setId(id);
        department.setDescription(description);


        return department;
    }

//    public DepartmentModel assemble(Department department){
//
//        DepartmentModel departmentModel=new DepartmentModel(null);
//        departmentModel.setId(department.getId());
//        departmentModel.setName(department.getName());
//        departmentModel.setDescription(department.getDescription());
//
//
//        return departmentModel;
//    }
}

