package com.ems.emploee.Repository;

import com.ems.emploee.entity.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface attendancerepository extends CrudRepository<Attendance,Long> {
   // List<Attendance> findByEmployeeId(String employeeId);
    List<Attendance> findAttendanceByEmploy_Id(long emplId);
}
