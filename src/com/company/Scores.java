package com.company;

import java.util.HashMap;
import java.util.Map;

public class Scores{
    public Map scores = new HashMap();

    public Scores() {
        this.scores = new HashMap();
    }

    public void addScore(String name, int points){
        scores.put(name, points);
    }

    public Map getScores() {
        //TODO: sort in descending order
        return scores;
    }

    public void setScores(Map scores) {
        this.scores = scores;
    }
}
