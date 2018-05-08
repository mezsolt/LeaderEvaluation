package com.LeaderEvaluation.service;

import com.LeaderEvaluation.entity.DeletedDataEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.05.05..
 */

@Service
public interface DeletedDataService {
    List<DeletedDataEntity> getDeletedDataEntites();
    void addDeletedData(DeletedDataEntity deletedDataEntity);
}
