package snakesAndLadders.models;

public class Cell {
    int id;
    CellType type;

    public Cell(int id, CellType type){
        this.id= id;
        this.type= type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type+"";
    }
}
