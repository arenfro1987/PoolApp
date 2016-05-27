package com.innovateeverything.drenfro87.poolapp;

import java.io.Serializable;

/**
 * Created by drenf on 5/25/2016.
 */
public class Player implements Serializable{
    private String name;
    private int handicap;
    private int gamesWon;

    public Player() {
        handicap = 0;
        gamesWon = 0;
    }

    public Player(String name, int handicap, int gamesWon) {
        this.name = name;
        this.handicap = handicap;
        this.gamesWon = gamesWon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        if(gamesWon < 1)
        {
            gamesWon = 0;
        }
        this.gamesWon = gamesWon;
    }
}
