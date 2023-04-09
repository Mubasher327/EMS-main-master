package com.ems.emploee.Repository;

import com.ems.emploee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentrepository extends JpaRepository<Department,Long> {
}
