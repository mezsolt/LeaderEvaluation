package com.LeaderEvaluation.service;

import com.LeaderEvaluation.entity.EvaluationEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public interface EvaluationService {

    EvaluationEntity addEvaluation(EvaluationEntity evaluationEntity);
    List<EvaluationEntity> listEvaluations();
}
