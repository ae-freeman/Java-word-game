package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(1, "Easy");
        play();

//        game.getNumberPlayers();
//
//        Player annie = new Player("Annie", 0);
//
//        game.addPlayer(annie);
//        game.getPlayers();
//        game.addPlayer(annie);
//
//        game.splitWord("hello");
//
//        game.checkWord("hello", "hello", annie);
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
