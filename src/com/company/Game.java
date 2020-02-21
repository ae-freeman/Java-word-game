package com.company;

import java.util.ArrayList;

public class Game {
    private int numberPlayers;
    private String difficulty;
    private ArrayList<Player> players; //Generics -> can only add object of type player to the game

    public Game(int numberPlayers, String difficulty) {
        this.numberPlayers = numberPlayers;
        this.difficulty = difficulty;
        this.players = new ArrayList<Player>();
    }

    public int getNumberPlayers() {
        System.out.println("Number of players: " + numberPlayers);
        return numberPlayers;
    }

    public void setNumberPlayers(int numberPlayers) {
        this.numberPlayers = numberPlayers;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public static void test(){
        System.out.println("Working");
    }
}
