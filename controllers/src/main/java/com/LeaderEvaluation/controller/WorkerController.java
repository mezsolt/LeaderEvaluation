package com.LeaderEvaluation.controller;

import com.LeaderEvaluation.entity.WorkerEntity;
import com.LeaderEvaluation.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mezsolt on 2018.03.25..
 */

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {

    private WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    String message() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return "workerMessage " + currentPrincipalName;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    void addWorker(@RequestBody WorkerEntity newWorker) {
        workerService.addWorker(newWorker);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    List<WorkerEntity> listWorkers() {
        return workerService.listWorkers();
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    WorkerEntity getWorker() {
        return workerService.findOneByUsername("ferko");
    }

}
