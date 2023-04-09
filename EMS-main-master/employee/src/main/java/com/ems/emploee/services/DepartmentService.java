package com.ems.emploee.services;

import com.ems.emploee.Repository.departmentrepository;
import com.ems.emploee.entity.Department;
import com.ems.emploee.model.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {
    @Autowired
    private departmentrepository jobdepartmentRepo;


    public DepartmentModel addDepartment(DepartmentModel department) {
        return  department.assemble(jobdepartmentRepo.save(department.dissamble()));
    }

    public String deleteDepartment(long departId) {
        jobdepartmentRepo.deleteById(departId);
        return "Employee Department Details Deleted SuccessFully";
    }
    public Department getDepartEntity(long id){
        return jobdepartmentRepo.findById(id).get();
    }
    public List<DepartmentModel> getDepartment(){
        return jobdepartmentRepo.findAll().stream().map(DepartmentModel::new).collect(Collectors.toList());
    }
}
