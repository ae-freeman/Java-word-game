package com.company;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(1, "Easy");

        game.test();
        game.getNumberPlayers();

        Player annie = new Player("Annie", 0);

        game.addPlayer(annie);
        game.getPlayers();
        game.addPlayer(annie);

        game.splitWord("hello");

        game.checkWord("hello", "hello");
    }
}
