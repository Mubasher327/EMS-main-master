package com.ems.emploee.Repository;

import com.ems.emploee.entity.Employee;
import com.ems.emploee.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface registeredemployeerepository extends JpaRepository<Employee,Long> {

List<Employee> findEmployeeByDepartment_Id(long id);
List<Employee> findEmployeeByDepartment_Name(String deptName);
}

