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
        if (points == 1){
            System.out.println(getName() + " has " + points + " point");
        } else {
            System.out.println(getName() + " has " + points + " points");
        }
        return points;
    }

    public void setPoints(int difficulty) {
        if(difficulty == 1){
            this.points++;
        } else if(difficulty == 2){
            this.points += 2;
        } else {
            this.points += 3;
        }

    }
}
