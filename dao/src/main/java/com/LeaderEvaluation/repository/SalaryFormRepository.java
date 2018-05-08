package com.LeaderEvaluation.repository;

import com.LeaderEvaluation.entity.SalaryFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by mezsolt on 2018.04.27..
 */

@Repository
public interface SalaryFormRepository extends JpaRepository<SalaryFormEntity,Long>{
}
