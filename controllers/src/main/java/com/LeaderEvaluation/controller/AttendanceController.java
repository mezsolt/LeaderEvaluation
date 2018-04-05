package com.LeaderEvaluation.controller;

import com.LeaderEvaluation.entity.AttendanceEntity;
import com.LeaderEvaluation.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@RestController
@RequestMapping(value = "/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    String message() {
        return "attendanceMessage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void addAttendance(@RequestBody AttendanceEntity newAttendance) {
        attendanceService.addAttendance(newAttendance);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<AttendanceEntity> listAttendances() {
        return attendanceService.listAttendances();
    }
}
