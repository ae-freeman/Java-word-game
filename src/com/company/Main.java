package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

//        // Load words into hashSet for faster look up times
//        HashSet<String> dictionary = new HashSet<String>();
//        Scanner fileScan = new Scanner(new File("small_dictionary.txt"));
//        while (fileScan.hasNextLine()) {
//            dictionary.add(fileScan.nextLine().toLowerCase());
//        }

        play();

    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        //Initialise new scores class
        Scores scores = new Scores();

        printMenu();



        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:


                    System.out.println("Welcome to the word guessing game!");

                    // Get number of players
                    System.out.println("How many people are playing?");
                    int numberPlayers = 0;

                    while (true) {
                        try {
                            numberPlayers = scanner.nextInt();
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Please enter an integer");
                            scanner.next();

                        }
                    }


                    // Get difficulty
                    System.out.println("Choose difficulty:\n 1 - Easy\n 2 - Medium\n 3 - Hard");
                    int difficulty = 0;
                    while (true) {
                        try {
                            difficulty = scanner.nextInt();
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Please choose 1, 2 or 3");
                            scanner.next();
                        }
                    }


                    // Load word file corresponding to selected difficulty
                    HashSet<String> dictionary = new HashSet<>();
                    try {
                        Scanner fileScan = new Scanner(new File(difficulty + ".txt"));
//                        Scanner fileScan = new Scanner(new File("small_dictionary.txt"));
                        while (fileScan.hasNextLine()) {
                            dictionary.add(fileScan.nextLine().toLowerCase());
                        }
                    } catch (Exception e) {
                        System.out.println("Error loading file");
                    }

                    // Create new game with chosen player number and difficulty level
                    Game game = new Game(numberPlayers, difficulty);


                    // Up to the number of players, get names, create new players and add to array list
                    for (int i = 0; i < numberPlayers; i++) {
                        while (true) {
                            System.out.println("Player " + (i + 1) + " name:");
                            String name = scanner.next();
                            Player player = new Player(name, 0);
                            if (game.addPlayer(player)) {
                                break;

                            }

                        }

                    }

                    System.out.println("Game players:");
                    game.getPlayers();

                    //For each player in the game, guess the given word
                    for (int i = 0; i < numberPlayers; i++) {
                        System.out.println("Rearrange the letters  of the scrambled word!");
                        System.out.println("");
                        //TODO: Add breaks between each announcement, press enter to go to next thing
                        System.out.println("It is " + game.players.get(i).getName() + "'s turn");
                        System.out.println("");

                        // Initialise variables
                        Object gameWord = null;
                        String playerAnswer = "";
                        int newWordCounter = 0;
                        boolean hasUsedHint = false;

                        // Get answer from player
                        while (newWordCounter < 3) {
                            gameWord = game.getGameWord(dictionary);
                            game.splitWord(gameWord.toString());
                            if (newWordCounter == 1) {
                                System.out.println("Type your answer or press n for new word (you have " + (2 - newWordCounter) + " new word left)");
                            } else {
                                System.out.println("Type your answer or press n for new word (you have " + (2 - newWordCounter) + " new words left)");
                            }
                            System.out.println("Press f to get first letter of word (-0.5 points)");

                            playerAnswer = scanner.next();

                            if (playerAnswer.toLowerCase().equals("f")) {
                                game.printFirstLetter(gameWord);
                                hasUsedHint = true;
                                playerAnswer = scanner.next();
                            }

                            if (!playerAnswer.toLowerCase().equals("n")) {

                                break;
                            }
                            newWordCounter++;
                        }

                        // Check if player answered correctly
                        game.checkWord(playerAnswer, gameWord.toString(), game.players.get(i), difficulty, hasUsedHint);

                        //Add player score to scores class
                        scores.addScore(game.players.get(i).getName(), game.players.get(i).getPoints());

                    }
                    System.out.println("Press 2 to return to game menu");

                    break;
                case 1:
                    System.out.println("Previous scores");
                    System.out.println(scores.getScores());
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

    private static void printMenu() {
        System.out.println("Hello! Do you want to play the game?");
        System.out.println("0 - to start new game\n" +
                "1 - to see previous scores\n" +
                "2 - print menu\n" +
                "3 - to quit\n");
    }


}


