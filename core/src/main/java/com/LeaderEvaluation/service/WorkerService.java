package com.LeaderEvaluation.service;


import com.LeaderEvaluation.entity.WorkerEntity;

import java.util.List;

/**
 * Created by mezsolt on 2018.03.25..
 */

public interface WorkerService {
    WorkerEntity addWorker(WorkerEntity workerEntity);
    List<WorkerEntity> listWorkers();
    WorkerEntity findOneByUsername(String username);
}
