package com.sport.football.model;

import javax.persistence.*;

@Entity
@Table
public class FootBallInfo {
    @Id
    @GeneratedValue(generator = "true",strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String match_name;
    @Column
    private String match_time;
    @Column
    private String match_score;
    @Column
    private String match_location;

    public FootBallInfo() {
    }

    public FootBallInfo(String match_name, String match_time, String match_score, String match_location) {
        this.match_name = match_name;
        this.match_time = match_time;
        this.match_score = match_score;
        this.match_location = match_location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatch_name() {
        return match_name;
    }

    public void setMatch_name(String match_name) {
        this.match_name = match_name;
    }

    public String getMatch_time() {
        return match_time;
    }

    public void setMatch_time(String match_time) {
        this.match_time = match_time;
    }

    public String getMatch_score() {
        return match_score;
    }

    public void setMatch_score(String match_score) {
        this.match_score = match_score;
    }

    public String getMatch_location() {
        return match_location;
    }

    public void setMatch_location(String match_location) {
        this.match_location = match_location;
    }
}
