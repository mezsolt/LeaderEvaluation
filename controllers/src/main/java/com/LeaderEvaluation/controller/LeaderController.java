package com.LeaderEvaluation.controller;

import com.LeaderEvaluation.entity.LeaderEntity;
import com.LeaderEvaluation.service.LeaderService;
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
@RequestMapping(value = "/leader")
public class LeaderController {

    @Autowired
    private LeaderService leaderService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    String message() {
        return "leaderMessage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void addLeader(@RequestBody LeaderEntity newLeader) {
        leaderService.addLeader(newLeader);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<LeaderEntity> listLeaders() {
        return leaderService.listLeaders();
    }
}
