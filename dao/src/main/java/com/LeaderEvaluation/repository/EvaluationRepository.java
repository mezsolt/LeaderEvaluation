package com.LeaderEvaluation.repository;

import com.LeaderEvaluation.entity.EvaluationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Repository
public interface EvaluationRepository extends CrudRepository<EvaluationEntity,Long> {
}
