package com.ems.emploee.services;

import com.ems.emploee.Repository.departmentrepository;
import com.ems.emploee.entity.Department;
import com.ems.emploee.model.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private departmentrepository jobdepartmentRepo;


    public DepartmentModel addDepartment(DepartmentModel department) {
        return  department.assemble(jobdepartmentRepo.save(department.dissamble()));
    }

    public String deleteDepartment(int departId) {
        jobdepartmentRepo.deleteById(departId);
        return "Employee Department Details Deleted SuccessFully";
    }
    public Department getDepartEntity(int id){
        return jobdepartmentRepo.findById(id).get();
    }
}
