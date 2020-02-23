package com.company;

public class Player {
    private String name;
    private int points;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        System.out.println(getName() + " has " + points + " points");
        return points;
    }

    public void setPoints() {
        this.points += 1;
    }
}
