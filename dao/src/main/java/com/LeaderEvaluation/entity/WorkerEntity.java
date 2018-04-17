package com.LeaderEvaluation.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by mezsolt on 2018.03.25..
 */

@Entity
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;
    private String section;
    private ArrayList<String> leaders;
    private ArrayList<String> roles;

    public WorkerEntity() {

    }

    public WorkerEntity(String username, String password, String section, ArrayList<String> leaders, ArrayList<String> roles) {
        this.username = username;
        this.password = password;
        this.section = section;
        this.leaders = leaders;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public ArrayList<String> getRoles() {
        return roles;
    }
    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }
}
