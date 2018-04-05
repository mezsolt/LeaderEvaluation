package com.LeaderEvaluation.repository;

import com.LeaderEvaluation.entity.LeaderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mezsolt on 2018.04.02..
 */
@Repository
public interface LeaderRepository extends CrudRepository<LeaderEntity,Long> {
}
