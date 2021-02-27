package The2048Game.models;

public class Cell {
    int rowNumber;
    int columnNumber;
    int value;

    public Cell(int row, int column, int value) {
        this.rowNumber= row;
        this.columnNumber= column;
        this.value= value;
    }
    public Cell(int row, int column) {
        this.rowNumber= row;
        this.columnNumber= column;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (rowNumber != cell.rowNumber) return false;
        return columnNumber == cell.columnNumber;
    }

    @Override
    public int hashCode() {
        int result = rowNumber;
        result = 313117 * result + columnNumber;
        return result;
    }

    @Override
    public String toString() {
        return "("+rowNumber+","+columnNumber+")=>"+value+" ";
    }
}
