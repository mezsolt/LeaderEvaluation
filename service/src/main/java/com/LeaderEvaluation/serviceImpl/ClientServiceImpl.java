package com.LeaderEvaluation.serviceImpl;

import com.LeaderEvaluation.entity.ClientEntity;
import com.LeaderEvaluation.repository.ClientRepository;
import com.LeaderEvaluation.service.ClientService;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mezsolt on 2018.04.21..
 */

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientEntity> getClients() {
        List<ClientEntity> clientEntities = clientRepository.findAll();
        Collections.shuffle(clientEntities);
        return clientEntities;
    }

    @Override
    public void addClient(ClientEntity clientEntity) {
        this.clientRepository.save(clientEntity);
    }

    @Override
    public List<ClientEntity> getClientsById(String id) {
        return this.clientRepository.findByIp(id);
    }

    @Override
    public boolean ipAllowed(String ip, LocalDateTime date) {
        List<ClientEntity> clientEntities = clientRepository.findAll();
        if(clientEntities.size()>0) {
            List<ClientEntity> sameIpList = new ArrayList<>();

            for(int i=0;i<clientEntities.size();i++) {
                if(clientEntities.get(i).getIp().equals(ip)){
                    sameIpList.add(clientEntities.get(i));
                }
            }

            for(int i=0;i<sameIpList.size();i++) {
                long diffInMinutes = Duration.between(LocalDateTime.parse(sameIpList.get(i).getSendDate()),date).toMinutes();;
                if((int)diffInMinutes < 2) {
                    System.out.println("ip already voted. " + diffInMinutes + " " + LocalDateTime.now().toString());
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public List<ClientEntity> deleteClient(String ip, String date) {
        List<ClientEntity> clientEntities = this.clientRepository.findAll();
        List<ClientEntity> deletedEntites = new ArrayList<>();

        for(int i=0;i<clientEntities.size();i++) {
            if(clientEntities.get(i).getIp().equals(ip) && clientEntities.get(i).getSendDate().equals(date)) {
                deletedEntites.add(clientEntities.get(i));
                this.clientRepository.deleteById(clientEntities.get(i).getId());
            }
        }
        return deletedEntites;
    }


}
