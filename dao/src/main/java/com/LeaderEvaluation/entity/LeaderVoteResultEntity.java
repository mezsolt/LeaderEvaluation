package com.LeaderEvaluation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by mezsolt on 2018.04.02..
 */

@Entity
public class LeaderVoteResultEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String leaderName;
    private int voteNumber;
    private int voteRatingSum;
    private double rating;
    private LocalDate creationDate;
    private Long evaluationId;

    public LeaderVoteResultEntity() {}

    public LeaderVoteResultEntity(String leaderName, int voteNumber, int voteRatingSum, double rating, LocalDate creationDate, Long evaluationId) {
        this.leaderName = leaderName;
        this.voteNumber = voteNumber;
        this.voteRatingSum = voteRatingSum;
        this.rating = rating;
        this.creationDate = creationDate;
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

    public int getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(int voteNumber) {
        this.voteNumber = voteNumber;
    }

    public int getVoteRatingSum() {
        return voteRatingSum;
    }

    public void setVoteRatingSum(int voteRatingSum) {
        this.voteRatingSum = voteRatingSum;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }
}
