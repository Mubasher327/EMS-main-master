package com.ems.emploee.controller;
import com.ems.emploee.model.AttendanceModel;
import com.ems.emploee.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {
@Autowired
    AttendanceService attendanceService;
@PostMapping("/save")
    public AttendanceModel addAttendance(@RequestBody AttendanceModel attendanceModel){
    attendanceService.addAttendance(attendanceModel);
    return attendanceModel;
}
@DeleteMapping("/delete/{id}")
    public String deleteAttendance(@PathVariable("id") int atten_id ){
    return attendanceService.deleteAttendance(atten_id);
}
}
