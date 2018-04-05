package com.LeaderEvaluation.serviceImpl;

import com.LeaderEvaluation.repository.LeaderVoteResultRepository;
import com.LeaderEvaluation.entity.LeaderVoteResultEntity;
import com.LeaderEvaluation.service.LeaderVoteResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public class LeaderVoteResultServiceImpl implements LeaderVoteResultService{

    @Autowired
    private LeaderVoteResultRepository leaderVoteResultRepository;

    @Override
    public LeaderVoteResultEntity addLeaderVoteResult(LeaderVoteResultEntity leaderVoteResultEntity) {
        return leaderVoteResultRepository.save(leaderVoteResultEntity);
    }

    @Override
    public List<LeaderVoteResultEntity> listLeaderVoteResults() {
        return (List<LeaderVoteResultEntity>)leaderVoteResultRepository.findAll();
    }
}
