package The2048Game.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
    Set<Cell> cells;

    public Board() {
        this.cells= new HashSet<>();
    }

    public Board(Set<Cell> cells) {
        this.cells = cells;
    }

    public Set<Cell> getCells() {
        return cells;
    }

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }
}
