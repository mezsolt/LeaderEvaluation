package com.LeaderEvaluation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Entity
public class VoteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String leaderName;
    private int rating;
    private Long evaluationId;

    public VoteEntity() {}


    public VoteEntity(String leaderName, int rating, Long evaluationId) {
        this.leaderName = leaderName;
        this.rating = rating;
        this.evaluationId = evaluationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }
}
