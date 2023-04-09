package com.ems.emploee.services;

import com.ems.emploee.Repository.registeredemployeerepository;
import com.ems.emploee.entity.Department;
import com.ems.emploee.entity.Employee;
import com.ems.emploee.model.EmployeeModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisteredEmployeeService {

 @Autowired
 private registeredemployeerepository registeremployeeRepo;

 @Autowired
 DepartmentService departmentService;

@Transactional
 public EmployeeModel addEmployee(EmployeeModel employee) {
  Department department = departmentService.getDepartEntity(employee.getDepartmentModel().getId());
  return employee.assemble(registeremployeeRepo.save(employee.dissamble()));

 }
@Transactional
 public void updateEmployee(Employee employee) {
  registeremployeeRepo.save(employee);

 }
@Transactional
 public String deleteEmployee(long empl_id) {
  registeremployeeRepo.deleteById(empl_id);
  return "Deleted";
 }

 public EmployeeModel getEmployee(long empl_id) {
  return new EmployeeModel(registeremployeeRepo.findById(empl_id).get());
 }
 public List<EmployeeModel> getAllEmployees() {

  List<EmployeeModel> employeeList = registeremployeeRepo.findAll()
          .stream()
          .map(EmployeeModel::new)
          .collect(Collectors.toList());
  return employeeList;
 }
 public List<EmployeeModel> findEmployee(Long id, String name){
 List<EmployeeModel>employeeModels = new ArrayList<>();
 if(id!=null){
  employeeModels=List.of(registeremployeeRepo.findAll()
          .stream().map(EmployeeModel::new)
          .filter(employeeModel -> employeeModel.getId()==id)
          .findFirst()
          .get());
 } else if (name!=null) {
  employeeModels=List.of(registeremployeeRepo.findAll()
          .stream().map(EmployeeModel::new)
          .filter(employeeModel -> employeeModel.getFullName().equalsIgnoreCase(name))
          .findFirst()
          .get());
 }else {
employeeModels=registeremployeeRepo.findAll().stream().map(EmployeeModel::new).collect(Collectors.toList());
 }

  return employeeModels;
 }
}


