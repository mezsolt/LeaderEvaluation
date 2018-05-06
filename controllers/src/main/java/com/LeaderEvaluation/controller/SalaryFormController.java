package com.LeaderEvaluation.controller;

import com.LeaderEvaluation.entity.ClientEntity;
import com.LeaderEvaluation.entity.DeletedDataEntity;
import com.LeaderEvaluation.entity.SalaryFormEntity;
import com.LeaderEvaluation.entity.VerifyingCodeEntity;
import com.LeaderEvaluation.model.SearchSalaryRequest;
import com.LeaderEvaluation.service.ClientService;
import com.LeaderEvaluation.service.DeletedDataService;
import com.LeaderEvaluation.service.SalaryFormService;
import com.LeaderEvaluation.service.VerifyingCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by mezsolt on 2018.04.27..
 */

@RestController
@RequestMapping(value = "/salary")
public class SalaryFormController {

    @Autowired
    private SalaryFormService salaryFormService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private VerifyingCodeService verifyingCodeService;

    @Autowired
    private DeletedDataService deletedDataService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private List<SalaryFormEntity> getSalaryForms() throws IOException {
        return this.salaryFormService.getSalaryForms();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    private void addSalaryForm(@RequestParam String code, @RequestBody SalaryFormEntity salaryFormEntity, HttpServletRequest request) throws IOException {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
        if(code.equals("null")) {
            if(this.clientService.ipAllowed(request.getRemoteAddr(),date)) {
                this.salaryFormService.addSalaryForm(salaryFormEntity);
                this.clientService.addClient(new ClientEntity(request.getRemoteAddr(), date.toString()));
            }
        } else {
            if(this.clientService.ipAllowed(request.getRemoteAddr(),date)){
                this.salaryFormService.addSalaryForm(salaryFormEntity);
                this.clientService.addClient(new ClientEntity(request.getRemoteAddr(),date.toString()));
                VerifyingCodeEntity verifyingCodeEntity = new VerifyingCodeEntity();
                verifyingCodeEntity.setVerifyingCode(code);
                this.verifyingCodeService.addCode(verifyingCodeEntity);
            }
        }

    }

    @RequestMapping(value = "/getOne",method = RequestMethod.POST)
    private SalaryFormEntity getOneSalaryForm(@RequestBody Long id) {
        return this.salaryFormService.getSalaryFormById(id);
    }

    @RequestMapping(value = "/average",method = RequestMethod.POST)
    private int getAverageSalaryBySearchRequest(@RequestBody SearchSalaryRequest searchSalaryRequest) throws IOException {
        return this.salaryFormService.searchAverageSalaryByParameters(searchSalaryRequest);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    private void deleteSalaryForm(@RequestBody SearchSalaryRequest searchSalaryRequest) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<SalaryFormEntity> deletedSalaryEntities = this.salaryFormService.deleteSalaryFormBySearchRequest(searchSalaryRequest);

        for(int i=0;i<deletedSalaryEntities.size();i++) {
            this.deletedDataService.addDeletedData(new DeletedDataEntity(auth.getName(),deletedSalaryEntities.get(i).toString(),LocalDateTime.now().toString()));
        }
    }

    @RequestMapping(value = "/searchandlist",method = RequestMethod.POST)
    private List<SalaryFormEntity> getSalaryFormsBySearchRequest(@RequestBody SearchSalaryRequest searchSalaryRequest) throws IOException {
        return this.salaryFormService.getSalaryFormListBySearchRequest(searchSalaryRequest);
    }
}
