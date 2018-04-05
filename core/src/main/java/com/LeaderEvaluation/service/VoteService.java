package com.LeaderEvaluation.service;

import com.LeaderEvaluation.entity.VoteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public interface VoteService {

    VoteEntity addVote(VoteEntity voteEntity);
    List<VoteEntity> listVotes();
}
