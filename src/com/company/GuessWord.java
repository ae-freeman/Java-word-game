package com.company;

public class GuessWord extends Game {
    public String word;

    public GuessWord(int numberPlayers, String difficulty, String gameType, String word) {
        super(numberPlayers, difficulty,gameType);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String[] splitWord(String word) {
        String[] splitWord = word.split("");
        return splitWord;

    }
}
