package com.LeaderEvaluation.service;

import com.LeaderEvaluation.entity.VerifyingCodeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mezsolt on 2018.05.03..
 */

@Service
public interface VerifyingCodeService {
    VerifyingCodeEntity getCode(String code);
    List<VerifyingCodeEntity> getAllCodes();
    void addCode(VerifyingCodeEntity verifyingCodeEntity);
    boolean searchCode(String code);
}
