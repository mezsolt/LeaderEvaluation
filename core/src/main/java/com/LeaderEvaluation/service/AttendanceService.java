package com.LeaderEvaluation.service;

import com.LeaderEvaluation.entity.AttendanceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public interface AttendanceService {

    AttendanceEntity addAttendance(AttendanceEntity attendanceEntity);
    List<AttendanceEntity> listAttendances();
}
