package com.ems.emploee.Repository;

import com.ems.emploee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface registeredemployeerepository extends JpaRepository<Employee,Integer> {
    }

