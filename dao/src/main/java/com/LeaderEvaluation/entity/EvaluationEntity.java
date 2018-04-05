package com.LeaderEvaluation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Entity
public class EvaluationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private ArrayList<String> leaderNames;
    private ArrayList<String> workerNames;
    private LocalDate startDate;
    private LocalDate endDate;

    public EvaluationEntity(String name, ArrayList<String> leaderNames, ArrayList<String> workerNames, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.leaderNames = leaderNames;
        this.workerNames = workerNames;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getLeaderNames() {
        return leaderNames;
    }

    public void setLeaderNames(ArrayList<String> leaderNames) {
        this.leaderNames = leaderNames;
    }

    public ArrayList<String> getWorkerNames() {
        return workerNames;
    }

    public void setWorkerNames(ArrayList<String> workerNames) {
        this.workerNames = workerNames;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
