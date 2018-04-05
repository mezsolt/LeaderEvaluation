package com.LeaderEvaluation.serviceImpl;

import com.LeaderEvaluation.repository.WorkerRepository;
import com.LeaderEvaluation.entity.WorkerEntity;
import com.LeaderEvaluation.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.03.25..
 */

@Service
public class WorkerServiceImpl implements WorkerService {

    WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }


    @Override
    public WorkerEntity addWorker(WorkerEntity workerEntity) {
        return workerRepository.save(workerEntity);

    }

    @Override
    public List<WorkerEntity> listWorkers() {
        return (List<WorkerEntity>)workerRepository.findAll();
    }
}

