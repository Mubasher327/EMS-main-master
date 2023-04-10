package com.ems.emploee.services;

import com.ems.emploee.Repository.attendancerepository;
import com.ems.emploee.entity.Attendance;
import com.ems.emploee.model.AttendanceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {
    double salary;
    @Autowired
    private attendancerepository attendanceRepo;
    @Autowired
    private RegisteredEmployeeService registeredEmployeeService;


    public AttendanceModel addAttendance(AttendanceModel attendanceModel){
        Attendance attendance=attendanceModel.dissamble();
       return attendanceModel.assemble(attendanceRepo.save(attendance));
    }
    public String deleteAttendance(long id) {
        attendanceRepo.deleteById(id);
        return "Employee Attendance Deleted successFully";
    }
    public String getAttendanceReport(int emplId) {
        List<Attendance> attendanceList = attendanceRepo.findAttendanceByEmploy_Id(emplId);
        List<Attendance> calAttendance = attendanceList.stream().filter((Attendance attendance) -> attendance.getIsEmplPresent()).collect(Collectors.toList());
        float percentage=(calAttendance.size() * 100) / attendanceList.size();
        String response;
        if(percentage>=90 && percentage<=100){
            response="Your salary is "+registeredEmployeeService.getEmployee(emplId).getSalary()+" for attendance "+percentage;
        } else if (percentage>=80&&percentage<90) {
            response="Your salary is "+(registeredEmployeeService.getEmployee(emplId).getSalary()-2000)+" for attendance "+percentage+"%";
        }else if (percentage>=70&&percentage<80) {
            response="Your salary is "+(registeredEmployeeService.getEmployee(emplId).getSalary()-4000)+" for attendance "+percentage+"%";
        }else if (percentage>=60&&percentage<70) {
            response="Your salary is "+(registeredEmployeeService.getEmployee(emplId).getSalary()-6000)+" for attendance "+percentage+"%";
        }else if (percentage>=50&&percentage<60) {
            response="Your salary is "+(registeredEmployeeService.getEmployee(emplId).getSalary()-8000)+" for attendance "+percentage+"%";
        }else {
            response="Your salary is "+(registeredEmployeeService.getEmployee(emplId).getSalary()/2)+" for attendance "+percentage+"%";
        }
        return response;

    }
}


