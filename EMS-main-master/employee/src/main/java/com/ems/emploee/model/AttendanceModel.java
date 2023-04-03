package com.ems.emploee.model;
import com.ems.emploee.entity.Attendance;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AttendanceModel {
    private int id;
    private Boolean isEmplPresent;
    private int timeIn;
    private int timeOut;

    private EmployeeModel employeeModel;

    public Attendance dissamble(){

        Attendance attendance=new Attendance();
        attendance.setId(id);
        attendance.setIsEmplPresent(isEmplPresent);
        attendance.setTimeIn(timeIn);
        attendance.setTimeOut(timeOut);
        attendance.setEmploy(employeeModel.dissamble());
        return attendance;

    }
    public AttendanceModel assemble(Attendance attendance){

        AttendanceModel attendanceModel=new AttendanceModel();

        attendanceModel.setId(attendance.getId());
        attendanceModel.setIsEmplPresent(attendance.getIsEmplPresent());
        attendanceModel.setTimeIn(attendance.getTimeIn());
        attendanceModel.setTimeOut(attendance.getTimeOut());
        attendanceModel.setEmployeeModel(employeeModel.assemble(attendance.getEmploy()));

        return attendanceModel;
    }
}
