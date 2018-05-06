package com.LeaderEvaluation.repository;

import com.LeaderEvaluation.entity.DeletedDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mezsolt on 2018.05.05..
 */

@Repository
public interface DeletedDataRepository extends JpaRepository<DeletedDataEntity,Long>{
}
