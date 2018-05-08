package com.LeaderEvaluation.serviceImpl;

import com.LeaderEvaluation.entity.DeletedDataEntity;
import com.LeaderEvaluation.repository.DeletedDataRepository;
import com.LeaderEvaluation.service.DeletedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.05.05..
 */

@Service
public class DeletedDataServiceImpl implements DeletedDataService {

    @Autowired
    private DeletedDataRepository deletedDataRepository;

    @Override
    public List<DeletedDataEntity> getDeletedDataEntites() {
        return deletedDataRepository.findAll();
    }

    @Override
    public void addDeletedData(DeletedDataEntity deletedDataEntity) {
        deletedDataRepository.save(deletedDataEntity);
    }
}
