package com.LeaderEvaluation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by mezsolt on 2018.03.25..
 */

@Entity
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String section;
    private ArrayList<String> leaders;

    public WorkerEntity() {

    }

    public WorkerEntity(String name, String section, ArrayList<String> leaders) {
        this.name = name;
        this.section = section;
        this.leaders = leaders;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public ArrayList<String> getLeaders() {
        return leaders;
    }

    public void setLeaders(ArrayList<String> leaders) {
        this.leaders = leaders;
    }
}
