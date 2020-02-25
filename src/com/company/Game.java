package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
    private int numberPlayers;
    private String difficulty;
    public ArrayList<Player> players = new ArrayList<>(); //Generics -> can only add object of type player to the game


    public Game(int numberPlayers, String difficulty) {
        this.numberPlayers = numberPlayers;
        this.difficulty = difficulty;
        this.players = new ArrayList<Player>();

    }

    // Add players to the players array list

    public boolean addPlayer(Player player){
        if (players.contains(player)) {
            //TODO: at the moment this is only true if same item in memory, implement an equalsTo override method?
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



    // Prepare jumbled word for player
    public String[] splitWord(String word) {
       String[] splitWord = word.split("");
        List<String> arrayWord = new ArrayList<>();
        arrayWord = Arrays.asList(splitWord);
        Collections.shuffle(arrayWord);

        for(String s: arrayWord){
            System.out.print(s);
        }
        System.out.println("");
        return splitWord;

    }

    // Check if answer is correct
    public boolean checkWord(String word, String originalWord, Player player){
        if(word.equals(originalWord)){
            System.out.println("Correct word!");
            player.setPoints();
            player.getPoints();
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
        for(Player player: players){
            System.out.print(player.getName());
            System.out.println("");
        }
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }


}
