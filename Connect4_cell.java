package com.example.project;

public class Connect4_cell {

    public boolean empty;
    public  Connect4_board.Turn player;

    public Connect4_cell() {
        empty = true;
    }

    public void setPlayer(Connect4_board.Turn player) {
        this.player = player;
        empty = false;
    }
}
