package com.ems.emploee.services;

import com.ems.emploee.Repository.attendancerepository;
import com.ems.emploee.entity.Attendance;
import com.ems.emploee.model.AttendanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    @Autowired
    private attendancerepository attendanceRepo;


    public AttendanceModel addAttendance(AttendanceModel attendanceModel){
        Attendance attendance=attendanceModel.dissamble();
       return attendanceModel.assemble(attendanceRepo.save(attendance));
    }
    public String deleteAttendance(int id) {
        attendanceRepo.deleteById(id);
        return "Employee Attendance Deleted successFully";
    }

}
