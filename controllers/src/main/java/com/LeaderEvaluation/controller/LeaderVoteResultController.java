package com.LeaderEvaluation.controller;

import com.LeaderEvaluation.entity.LeaderVoteResultEntity;
import com.LeaderEvaluation.service.LeaderVoteResultService;
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
@RequestMapping(value = "/leadervoteresult")
public class LeaderVoteResultController {

    @Autowired
    private LeaderVoteResultService leaderVoteResultService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    String message() {
        return "leaderVoteResultMessage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void addLeaderVoteResult(@RequestBody LeaderVoteResultEntity newLeaderVoteResult) {
        leaderVoteResultService.addLeaderVoteResult(newLeaderVoteResult);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<LeaderVoteResultEntity> listLeaderVoteResults() {
        return leaderVoteResultService.listLeaderVoteResults();
    }
}
