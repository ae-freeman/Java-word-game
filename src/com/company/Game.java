package com.company;

import java.util.*;

public class Game {
    private int numberPlayers;
    private String difficulty;
    private ArrayList<Player> players = new ArrayList<>(); //Generics -> can only add object of type player to the game


    public Game(int numberPlayers, String difficulty) {
        this.numberPlayers = numberPlayers;
        this.difficulty = difficulty;
        this.players = new ArrayList<Player>();

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

    public String[] splitWord(String word) {
       String[] splitWord = word.split("");
        List<String> arrayWord = new ArrayList<>();
        arrayWord = Arrays.asList(splitWord);
        Collections.shuffle(arrayWord);

        for(String s: arrayWord){
            System.out.print(s);
        }
        System.out.println("");
        return  splitWord;

    }

    public boolean checkWord(String word, String originalWord){
        if(word == originalWord){
            System.out.println("Correct word!");
            return true;
        } else {
            System.out.println("Incorrect word!");
            return false;
        }
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
