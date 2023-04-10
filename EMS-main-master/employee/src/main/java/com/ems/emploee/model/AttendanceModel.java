package com.ems.emploee.model;
import com.ems.emploee.entity.Attendance;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class AttendanceModel {
    private long id;
    private Boolean isEmplPresent;
    private Date date;
    private String timeIn;
    private String timeOut;

    private EmployeeModel employeeModel;

    public Attendance dissamble(){

        Attendance attendance=new Attendance();
        attendance.setId(this.id);
        attendance.setIsEmplPresent(this.isEmplPresent);
        attendance.setDate(this.date);
        attendance.setTimeIn(this.timeIn);
        attendance.setTimeOut(this.timeOut);
        attendance.setEmploy(this.employeeModel.dissamble());
        return attendance;

    }
    public AttendanceModel assemble(Attendance attendance){

        AttendanceModel attendanceModel=new AttendanceModel();

        attendanceModel.setId(attendance.getId());
        attendanceModel.setIsEmplPresent(attendance.getIsEmplPresent());
        attendanceModel.setDate(attendance.getDate());
        attendanceModel.setTimeIn(attendance.getTimeIn());
        attendanceModel.setTimeOut(attendance.getTimeOut());
        attendanceModel.setEmployeeModel(new EmployeeModel(attendance.getEmploy()));

        return attendanceModel;
    }
}
