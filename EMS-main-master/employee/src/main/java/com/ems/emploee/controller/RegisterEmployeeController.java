package com.ems.emploee.controller;


import com.ems.emploee.entity.Employee;
import com.ems.emploee.model.EmployeeModel;
import com.ems.emploee.services.RegisteredEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class RegisterEmployeeController {
    @Autowired
    RegisteredEmployeeService registeredEmployeeServices;

    @PostMapping("/save")
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employeeModel)
    {
        return registeredEmployeeServices.addEmployee(employeeModel);
    }
/*    @GetMapping("/register")
    public String showForm(EmployeeModel employeeModel) {
        EmployeeModel user = new EmployeeModel();
        EmployeeModel.addAttribute("employee", employeeModel);

        List<String> listDesignation = Arrays.asList("Developer", "Designer", "Architect");
        employeeModel.addAttribute("listDesignation", (EmployeeModel) listDesignation);

        return "register_form";
    }
    @PostMapping("/register1")
    public String submitForm(@ModelAttribute("user") EmployeeModel employeeModel) {
        System.out.println(employeeModel);
        return "register_success";
    }*/
@PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee)
{
        registeredEmployeeServices.updateEmployee(employee);
    }
@DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long empl_id){
       return registeredEmployeeServices.deleteEmployee(empl_id);
}



@GetMapping("/search")
    private List<EmployeeModel> getEmployeeById(@RequestParam(name = "id",required = false)Long id , @RequestParam(name = "name",required = false)String name){
    return registeredEmployeeServices.findEmployee(id,name);
}
}
