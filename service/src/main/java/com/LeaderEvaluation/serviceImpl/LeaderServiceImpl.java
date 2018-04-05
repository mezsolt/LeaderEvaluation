package com.LeaderEvaluation.serviceImpl;

import com.LeaderEvaluation.repository.LeaderRepository;
import com.LeaderEvaluation.entity.LeaderEntity;
import com.LeaderEvaluation.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public class LeaderServiceImpl implements LeaderService{

    @Autowired
    private LeaderRepository leaderRepository;

    @Override
    public LeaderEntity addLeader(LeaderEntity leaderEntity) {
        return leaderRepository.save(leaderEntity);
    }

    @Override
    public List<LeaderEntity> listLeaders() {
        return (List<LeaderEntity>)leaderRepository.findAll();
    }
}

