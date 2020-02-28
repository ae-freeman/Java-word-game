package com.company;

import java.util.HashMap;
import java.util.Map;

public class Scores{
    public Map scores = new HashMap();

    public Scores() {
        this.scores = new HashMap();
    }

    //TODO: Currently adding a new player -> if name already exists, get that name and add to it.

    public void addScore(String name, double points){
        if (scores.containsKey(name)) {
            Object oldValue = scores.get(name);
            double newValue = (Double) oldValue + points;
            scores.replace(name, newValue);
        } else {
            scores.put(name, points);
        }

    }

    public Map getScores() {
        //TODO: sort in descending order -> use a treeMap
        return scores;
    }

    public void setScores(Map scores) {
        this.scores = scores;
    }
}
