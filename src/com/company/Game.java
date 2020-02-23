package com.company;

import java.util.ArrayList;

public class Game {
    private int numberPlayers;
    private String difficulty;
    private ArrayList<Player> players = new ArrayList<>(); //Generics -> can only add object of type player to the game
    private String gameType;

    public Game(int numberPlayers, String difficulty, String gameType) {
        this.numberPlayers = numberPlayers;
        this.difficulty = difficulty;
        this.players = new ArrayList<Player>();
        this.gameType = gameType;
    }

    // Add players to the players array list

    public boolean addPlayer(Player player){
        if (players.contains(player)) {
            System.out.println(player.getName() + " is already playing in this game");
            return false;
        } else {
            players.add(player);
            System.out.println(player.getName() + " is playing!");
            return true;
        }
    }

    public int getNumberPlayers() {
        System.out.println("Number of players: " + numberPlayers);
        return numberPlayers;
    }

    public String[] returnGameWord(String word) {
        splitWord
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
