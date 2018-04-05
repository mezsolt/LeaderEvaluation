package com.LeaderEvaluation.serviceImpl;

import com.LeaderEvaluation.repository.VoteRepository;
import com.LeaderEvaluation.entity.VoteEntity;
import com.LeaderEvaluation.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public class VoteServiceImpl implements VoteService{

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public VoteEntity addVote(VoteEntity voteEntity) {
        return voteRepository.save(voteEntity);
    }

    @Override
    public List<VoteEntity> listVotes() {
        return (List<VoteEntity>)voteRepository.findAll();
    }
}

