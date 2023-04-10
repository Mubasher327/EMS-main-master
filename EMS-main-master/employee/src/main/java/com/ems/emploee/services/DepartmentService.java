package com.ems.emploee.services;

import com.ems.emploee.Repository.departmentrepository;
import com.ems.emploee.entity.Department;
import com.ems.emploee.model.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private departmentrepository jobDepartmentRepo;


    public DepartmentModel addDepartment(DepartmentModel department) {
        return  new DepartmentModel(jobDepartmentRepo.save(department.dissamble()));
    }

    public String deleteDepartment(long departId) {
        jobDepartmentRepo.deleteById(departId);
        return "Employee Department Details Deleted SuccessFully";
    }
    public Department getDepartEntity(long id){
        return jobDepartmentRepo.findById(id).get();
    }
    public List<DepartmentModel> getDepartment(){
        return jobDepartmentRepo.findAll().stream().map(DepartmentModel::new).collect(Collectors.toList());
    }
}
