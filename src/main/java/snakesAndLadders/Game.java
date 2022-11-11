package snakesAndLadders;

import snakesAndLadders.models.*;
import snakesAndLadders.service.GameManager;

import java.util.*;

/*
Input structure -
Number of snakes
All positions ( snake_head snake_tail ) and (head>tail)

Number of ladders
All positions( ladder_start ladder_end) and (start<end)

Number of players
All names of players

Sample input:
9
62 5
33 6
49 9
88 16
41 20
56 53
98 64
93 73
95 75
8
2 37
27 46
10 32
51 68
61 79
65 84
71 91
81 100
4
ishan
rishu
ayush
dabbu
 */

public class Game {
    private Map<Integer, Snake> snakes;
    private Map<Integer, Ladder> ladders;
    private Map<String, Player> players;
    private List<Cell> cells;

    private boolean isGameOver;

    private Board board;

    public Game(){}

    public Map<Integer, Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Snake> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = players;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Game(Map<Integer,Snake> snakes, Map<Integer, Ladder> ladders, List<Cell> cells, Map<String, Player> players, Board board){
        this.isGameOver= false;
        this.snakes= snakes;
        this.ladders= ladders;
        this.cells= cells;
        this.board= board;
        this.players= players;
    }

    public static void main(String[] args) throws InterruptedException {
        GameManager manager= new GameManager();
        manager.startGame();
    }
}
