package The2048Game.service;

import The2048Game.models.Board;
import The2048Game.models.Cell;

import java.util.*;

public class GameManager {
    Board board;
    Cell[][] cellArray;
    private static final int ROWS = 4;
    private static final int COLUMNS = 4;
    boolean isGameFinished;

    public GameManager(){
        cellArray= new Cell[ROWS][COLUMNS];
        resetBoard();
        board= new Board();
        isGameFinished= false;
    }

    private void resetBoard() {
        for(Cell[] cellA: cellArray)
            Arrays.fill(cellA, null);
    }

    public void startGame() {
        initialiseBoard();
        printBoard();
        while(!isGameFinished){
            executeTurn();
        }
    }

    private void executeTurn() {
        Scanner sc= new Scanner(System.in);
        String input= sc.nextLine();
        if(input==null)
            input= sc.nextLine();

        switch (input) {
            case "w" -> slideUp();
            case "s" -> slideDown();
            //case 'a' -> slideLeft();
            //case 'd' -> slideRight();
            default -> System.out.println("Enter w,a,s,d");
        }
    }
    private void slideDown() {
        System.out.println("Sliding down");
        Stack<Cell> stack= new Stack<>();
        List<Cell> list= new ArrayList<>();
        for(int column=0; column<COLUMNS; column++){
            Cell prev= null;
            for(int row=ROWS-1; row>=0; row--){
                Cell current= cellArray[row][column];
                if(current!=null){
                    stack.push(current);
                    if(stack.size()>1){
                        if(prev!=null && prev.getValue()==current.getValue()){
                            System.out.println("Matching at index: ("+prev.getRowNumber()+","+prev.getColumnNumber()+") and ("+current.getRowNumber()+","+current.getColumnNumber()+")");

                            Cell c1= stack.pop();
                            Cell c2= stack.pop();
                            Cell newCell= new Cell(ROWS -stack.size()-1, column,c1.getValue()+c2.getValue());
                            list.add(newCell);
                            stack.push(newCell);
                            System.out.println("New list: "+list);
                            removeCell(c1, "stack in loop");
                            removeCell(c2, "stack in loop");
                        }
                    }
                    prev= current;
                }
            }
            while(!stack.isEmpty()){
                Cell placeholderCell= stack.pop();
                list.add(new Cell(ROWS-stack.size()-1, column, placeholderCell.getValue()));
                removeCell(placeholderCell, "empty the stack");
            }
        }
        resetBoard();
        for(Cell cell: list){
            addCell(cell, "list");
        }
        addCell(randomCellGenerator(), "randomGenerator");
        printBoard();
    }

    private void slideUp() {
        Stack<Cell> stack= new Stack<>();
        List<Cell> list= new ArrayList<>();
        for(int column=0; column<COLUMNS; column++){
            Cell prev= null;
            for(int row=0; row<ROWS; row++){
                Cell current= cellArray[row][column];
                if(current!=null){
                    stack.push(current);
                    if(stack.size()>1){
                        if(prev!=null && prev.getValue()==current.getValue()){
                            System.out.println("Matching at index: ("+prev.getRowNumber()+","+prev.getColumnNumber()+") and ("+current.getRowNumber()+","+current.getColumnNumber()+")");

                            Cell c1= stack.pop();
                            Cell c2= stack.pop();
                            Cell newCell= new Cell(stack.size(), column,c1.getValue()+c2.getValue());
                            list.add(newCell);
                            stack.push(newCell);
                            System.out.println("New list: "+list);
                            removeCell(c1, "stack in loop");
                            removeCell(c2, "stack in loop");
                        }
                    }
                    prev= current;
                }
            }
            while(!stack.isEmpty()){
                Cell placeholderCell= stack.pop();
                list.add(0,new Cell(stack.size(), column, placeholderCell.getValue()));
                removeCell(placeholderCell, "stack");
            }
        }
        resetBoard();
        for(Cell cell: list){
            addCell(cell, "list");
        }
        addCell(randomCellGenerator(), "randomGenerator");
        printBoard();
    }

    private void addCell(Cell cell, String source) {
        System.out.println("Adding cell: "+cell+" from "+source);
        if(cellArray[cell.getRowNumber()][cell.getColumnNumber()]!=null)
            System.out.println("\tThe cell is not null");
        cellArray[cell.getRowNumber()][cell.getColumnNumber()]= new Cell(cell.getRowNumber(), cell.getColumnNumber(), cell.getValue());
    }

    private void removeCell(Cell cell, String source) {
        System.out.println("Removing cell: "+cell+" from "+source);
        cellArray[cell.getRowNumber()][cell.getColumnNumber()].setValue(0);
    }

    private void initialiseBoard() {
        Cell randomCell= randomCellGenerator();
        cellArray[randomCell.getRowNumber()][randomCell.getColumnNumber()]=randomCell;
        randomCell= randomCellGenerator();
        cellArray[randomCell.getRowNumber()][randomCell.getColumnNumber()]=randomCell;
    }

    private Cell randomCellGenerator(){
        int row= (int) ((Math.random()*100) % ROWS);
        int column= (int) ((Math.random()*100) %COLUMNS);
        if(cellArray[row][column]==null || cellArray[row][column].getValue()==0){
            cellArray[row][column] = new Cell(row, column, 2);
            return cellArray[row][column];
        }

        return randomCellGenerator();
    }

    private void printBoard(){
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLUMNS; j++){
                if(cellArray[i][j]!=null && cellArray[i][j].getValue()!=0)
                    System.out.print(" "+cellArray[i][j].getValue()+" ");
                else
                    System.out.print("   ");
                if(j<COLUMNS-1)
                    System.out.print(" | ");
            }
            System.out.println("\n____|_____|_____|____");
        }
    }
}
