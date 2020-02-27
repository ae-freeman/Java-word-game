package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
    private int numberPlayers;
    private int difficulty;
    public ArrayList<Player> players = new ArrayList<>(); //Generics -> can only add object of type player to the game


    public Game(int numberPlayers, int difficulty) {
        this.numberPlayers = numberPlayers;
        this.difficulty = difficulty;
        this.players = new ArrayList<Player>();

    }



    // Add players to the players array list

    public boolean addPlayer(Player player){
        String name = player.getName();
        for(Player currentPlayer: players){
            if(name.equals(currentPlayer.getName())){
                System.out.println(player.getName() + " is already playing in this game");
                return false;
            }

        }

            players.add(player);
            System.out.println(player.getName() + " is playing!");
            return true;

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



        // Print arrayList in a grid so it is harder to figure out
        int charCounter = 0;
        for(String s: arrayWord){
            if(charCounter % 3 == 0){
                System.out.println("");
            }
            System.out.print(s);
            charCounter++;

        }


        System.out.println("");
        return splitWord;

    }

    // Check if answer is correct
    public boolean checkWord(String word, String originalWord, Player player, int difficulty){
        //TODO: Check by letter instead of whole word by using ascii sum

        if(word.equals(originalWord)){
            System.out.println("Correct word!");
            player.setPoints(difficulty);
            return true;
        } else {
            System.out.println("Incorrect word!");
            System.out.println("The correct answer was " + originalWord);
            return false;
        }
    }

    public void setNumberPlayers(int numberPlayers) {
        this.numberPlayers = numberPlayers;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
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

    public static Object getGameWord(HashSet<String> dictionary){
        Random random = new Random();

        // Generate a random number between 0 and dictionary size - 1
        int randomNumber = random.nextInt(dictionary.size());

        //get an iterator
        Iterator iterator = dictionary.iterator();

        int currentIndex = 0;
        Object randomElement = null;

        //iterate the HashSet
        while(iterator.hasNext()){

            randomElement = iterator.next();

            //if current index is equal to random number
            if(currentIndex == randomNumber)
                return randomElement;

            //increase the current index
            currentIndex++;
        }

        return randomElement;
    }


}
