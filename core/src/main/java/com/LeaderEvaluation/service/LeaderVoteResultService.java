package com.LeaderEvaluation.service;

import com.LeaderEvaluation.entity.LeaderVoteResultEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public interface LeaderVoteResultService {

    LeaderVoteResultEntity addLeaderVoteResult(LeaderVoteResultEntity leaderVoteResultEntity);
    List<LeaderVoteResultEntity> listLeaderVoteResults();
}
