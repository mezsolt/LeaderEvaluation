package com.LeaderEvaluation.serviceImpl;

import com.LeaderEvaluation.repository.EvaluationRepository;
import com.LeaderEvaluation.entity.EvaluationEntity;
import com.LeaderEvaluation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Service
public class EvaluationServiceImpl  implements EvaluationService{

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public EvaluationEntity addEvaluation(EvaluationEntity evaluationEntity) {
        return evaluationRepository.save(evaluationEntity);
    }

    @Override
    public List<EvaluationEntity> listEvaluations() {
        return (List<EvaluationEntity>)evaluationRepository.findAll();
    }
}