package com.LeaderEvaluation.controller;

import com.LeaderEvaluation.entity.ClientEntity;
import com.LeaderEvaluation.entity.DeletedDataEntity;
import com.LeaderEvaluation.service.ClientService;
import com.LeaderEvaluation.service.DeletedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by mezsolt on 2018.04.21..
 */

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    DeletedDataService deletedDataService;

    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientEntity> listClients() {
        return this.clientService.getClients();
    }

    @RequestMapping(value = "/listbyid",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientEntity> getClientById(@RequestBody String id) {
        return this.clientService.getClientsById(id);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    private void deleteClient(@RequestParam String ip,@RequestParam String date) throws ParseException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<ClientEntity> deletedClientEntities = this.clientService.deleteClient(ip,date);
        for(int i=0;i<deletedClientEntities.size();i++) {
            this.deletedDataService.addDeletedData(new DeletedDataEntity(auth.getName(),deletedClientEntities.get(i).toString(),LocalDateTime.now().toString()));
        }
    }
}

