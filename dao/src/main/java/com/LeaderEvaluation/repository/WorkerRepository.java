package com.LeaderEvaluation.repository;

import com.LeaderEvaluation.entity.WorkerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mezsolt on 2018.03.25..
 */

@Repository
public interface WorkerRepository extends CrudRepository<WorkerEntity,Long> {
    WorkerEntity findOneByUsername(String username);
}
