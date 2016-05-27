package com.innovateeverything.drenfro87.poolapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by drenf on 5/25/2016.
 */
public class Game implements Serializable{
    private ArrayList<Player> players;
    private int gameTo;

    public Game() {
        players = new ArrayList<>();
        gameTo = 0;
    }

    public Game(ArrayList<Player> players, int gameTo) {
        this.players = players;
        this.gameTo = gameTo;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayers(Player player)
    {
        players.add(player);
    }

    public int getGameTo() {
        return gameTo;
    }

    public void setGameTo(int gameTo) {
        this.gameTo = gameTo;
    }
}
