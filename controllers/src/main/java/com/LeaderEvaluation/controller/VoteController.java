package com.LeaderEvaluation.controller;

import com.LeaderEvaluation.entity.VoteEntity;
import com.LeaderEvaluation.service.VoteService;
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
@RequestMapping(value = "/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    String message() {
        return "voteMessage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void addVote(@RequestBody VoteEntity newVote) {
        voteService.addVote(newVote);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<VoteEntity> listVotes() {
        return voteService.listVotes();
    }
}
