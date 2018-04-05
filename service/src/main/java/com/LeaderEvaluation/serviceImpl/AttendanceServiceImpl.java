package com.LeaderEvaluation.serviceImpl;

import com.LeaderEvaluation.repository.AttendanceRepository;
import com.LeaderEvaluation.entity.AttendanceEntity;
import com.LeaderEvaluation.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public class AttendanceServiceImpl  implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public AttendanceEntity addAttendance(AttendanceEntity attendanceEntity) {
        return attendanceRepository.save(attendanceEntity);
    }

    @Override
    public List<AttendanceEntity> listAttendances() {
        return (List<AttendanceEntity>)attendanceRepository.findAll();
    }
}