package com.company;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {


        HashSet<String> dictionary = new HashSet<String>();
        Scanner fileScan = new Scanner(new File("small_dictionary.txt"));
        while (fileScan.hasNextLine()) {
            dictionary.add(fileScan.nextLine().toLowerCase());
        }
        System.out.println(dictionary);


//        play();

    }

    private static void play(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        printMenu();

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Welcome to the word guessing game!");
                    System.out.println("How many people are playing?");
                    int numberPlayers = scanner.nextInt();
                    // TODO: change difficulty to numbers
                    System.out.println("Easy, medium or hard?");
                    String difficulty = scanner.next();
                    System.out.println(difficulty);
                    // Create new game
                    Game game = new Game(numberPlayers, difficulty);
                    // Up to the number of players, get names, create new players and add to array list
                    for(int i = 0; i < numberPlayers; i++){
                        System.out.println("Player " + (i + 1) + " name:");
                        String name = scanner.next();
                        Player player = new Player(name, 0);
                        game.addPlayer(player);
                        //TODO: allow for addPlayer error, and ask for name again
                        //try-catch block -> scanner.nextLine();
                        // print out what they need to do

                    }
                    System.out.println("Game players:");
                    game.getPlayers();
                    for (int i = 0; i < numberPlayers; i++){
                        System.out.println("Rearrange the letters  of the scrambled word!");
                        //TODO: Add breaks between each announcement, press something to go to next thing
                        System.out.println("It is " + game.players.get(i).getName() + "'s turn");
                        game.splitWord("hello");
                        System.out.println("Answer:");
                        String playerAnswer = scanner.next();
                        game.checkWord(playerAnswer, "hello", game.players.get(i));
                    }

                    // TODO: end of game, save scores to a scores class that can be called in previous scores method below

                    break;
                case 1:
                    System.out.println("Previous scores");
                    break;
                case 2:
                    printMenu();
                    break;
                case 3:
                    System.out.println("Quitting");
                    quit = true;
                    break;
            }
        }

    }

    private static void printMenu(){
        System.out.println("Hello! Do you want to play the game?");
        System.out.println("0 - to start new game\n" +
                "1 - to see previous scores\n" +
                "2 - print menu\n" +
                "3 - to quit\n");
    }
}
