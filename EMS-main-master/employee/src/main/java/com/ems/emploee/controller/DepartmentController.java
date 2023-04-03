package com.ems.emploee.controller;

import com.ems.emploee.entity.Department;
import com.ems.emploee.model.DepartmentModel;
import com.ems.emploee.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    DepartmentService jobDepartmentService;

    @PostMapping("/save")
    public DepartmentModel addJobdepartment(@RequestBody DepartmentModel departmentModel)
    {
        return jobDepartmentService.addDepartment(departmentModel);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") int depart_id){
        return jobDepartmentService.deleteDepartment(depart_id);
    }

}
