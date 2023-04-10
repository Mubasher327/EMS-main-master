package com.ems.emploee.controller;
import com.ems.emploee.model.AttendanceModel;
import com.ems.emploee.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/save")
    public AttendanceModel addAttendance(@RequestBody AttendanceModel attendanceModel) {
        attendanceService.addAttendance(attendanceModel);
        return attendanceModel;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAttendance(@PathVariable("id") long atten_id) {
        return attendanceService.deleteAttendance(atten_id);
    }
    @GetMapping("/get/{id}")
    public String getAttendanceRecord(@PathVariable(name = "id")int emplId){
        return attendanceService.getAttendanceReport(emplId);
    }
}