package com.LeaderEvaluation.service;

import com.LeaderEvaluation.entity.LeaderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public interface LeaderService {

    LeaderEntity addLeader(LeaderEntity leaderEntity);
    List<LeaderEntity> listLeaders();
}
