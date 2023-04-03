package com.ems.emploee.Repository;

import com.ems.emploee.entity.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface attendancerepository extends CrudRepository<Attendance,Integer> {

}
