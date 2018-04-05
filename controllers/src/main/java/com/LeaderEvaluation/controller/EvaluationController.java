package com.LeaderEvaluation.controller;

import com.LeaderEvaluation.entity.EvaluationEntity;
import com.LeaderEvaluation.service.EvaluationService;
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
@RequestMapping(value = "/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    String message() {
        return "evaluationMessage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void addEvaluation(@RequestBody EvaluationEntity newEvaluation) {
        evaluationService.addEvaluation(newEvaluation);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<EvaluationEntity> listEvaluations() {
        return evaluationService.listEvaluations();
    }
}