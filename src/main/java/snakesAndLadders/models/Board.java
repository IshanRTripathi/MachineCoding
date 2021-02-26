package snakesAndLadders.models;

import java.util.List;

/*
0 => nothing
1 => player
2 => snakeHead
3 => snakeTail
4 => ladderHead
5 => ladderTail
6 => destination
*/
public class Board {
    List<Cell> cells;

    public Board(List<Cell> cells){
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
