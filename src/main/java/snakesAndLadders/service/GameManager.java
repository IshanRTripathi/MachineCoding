package snakesAndLadders.service;


import snakesAndLadders.Game;
import snakesAndLadders.models.*;

import java.util.*;

/*
1. roll dice
2. update player position
3. check if game is over
4.
*/
public class GameManager {
    public Game game;

    public GameManager() {
        this.game= getInputs();
    }

    public void startGame() throws InterruptedException {
        while(!game.isGameOver()){
            for(String playerName: game.getPlayers().keySet()){
                if(game.isGameOver())
                    return;
                Player currentPlayer= game.getPlayers().get(playerName);
                System.out.println("\t\t\t\t\t\t\t\t\t"+playerName+"'s turn");
                playTurn(currentPlayer);
                game.setGameOver(currentPlayer.getCurrentPosition()>=100);
                //Thread.sleep(1500);
            }
        }
    }

    public void playTurn(Player player) {
        int diceValue= getDiceRollValue();
        String playerName= player.getPlayerName();
        int currentPosition= player.getCurrentPosition();

        int newPlayerPosition= currentPosition+diceValue;

        System.out.println("\t\t\t\t\t\t\t\t\tDice Value :"+diceValue);

        System.out.println(playerName+" jumps from "+currentPosition+" to "+ (Math.min(newPlayerPosition, 100)));
        player.setCurrentPosition(newPlayerPosition);
        game.setGameOver(checkIfPlayerWins(player));
        if(!game.isGameOver()) {
            updatePlayerPosition(player);
            game.setGameOver(checkIfPlayerWins(player));
        }
    }

    private boolean checkIfPlayerWins(Player player) {
        if(player.getCurrentPosition()>=100){
            System.out.println(player.getPlayerName()+ " wins !");
            return true;
        }
        return false;
    }

    private void updatePlayerPosition(Player player) {
        int currentPlayerPosition= player.getCurrentPosition();
        int newPlayerPosition= 0;
        Cell cell= game.getBoard().getCells().get(currentPlayerPosition);
        CellType cellType= cell.getType();

        switch (cellType) {
            case snake -> {
                newPlayerPosition = game.getSnakes().get(currentPlayerPosition).getTail();
                System.out.print(player.getPlayerName() + " bit by a snake ");
            }
            case ladder -> {
                Map<Integer, Ladder> ladders= game.getLadders();
                Ladder ladder= ladders.get(currentPlayerPosition);
                newPlayerPosition = ladder.getEnd();
                System.out.print(player.getPlayerName() + " takes a ladder ");
            }
            default -> newPlayerPosition = currentPlayerPosition;
        }
        if(newPlayerPosition != currentPlayerPosition)
            System.out.println("and moves to "+Math.min(newPlayerPosition, 100));
        else
            System.out.println();
        player.setCurrentPosition(newPlayerPosition);
    }

    private int getDiceRollValue() {
        return (int) ((Math.random()*100)%6) +1;
    }

    public void printBoard() {
        List<Cell> cells= game.getBoard().getCells();
        int itr=99;
        for(int i=1; i<=10; i++){
            for(int j=1; j<=10; j++){
                System.out.print(cells.get(itr--).getType());
            }
            System.out.println();
        }
    }

    public Game getInputs() {
        /*Game game= new Game();

        Board board= game.getBoard();
        Map<Integer, Snake> snakes= game.getSnakes();
        Map<Integer, Ladder> ladders= game.getLadders();
        Map<String, Player> players= game.getPlayers();
        List<Cell> cells= new ArrayList<>();

        for(int i=1; i<=100; i++){
            cells.add(new Cell(i, CellType.empty));
        }

        Scanner sc= new Scanner(System.in);
        System.out.println("Press Enter key to use default board configuration and any other key to get new configuration: ");

        String input= sc.nextLine();
        sc.nextLine();
        if(input== null || input.length()==0){
            return generateDefaultGameConfig();
        }
        else {
            int numberOfSnakes = sc.nextInt();

            for (int i = 0; i < numberOfSnakes; i++) {
                int head = sc.nextInt();
                int tail = sc.nextInt();
                snakes.put(head, new Snake(head, tail));
                cells.get(head).setType(CellType.snake);
            }

            int numberOfLadders = sc.nextInt();

            for (int i = 0; i < numberOfLadders; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                ladders.put(start, new Ladder(start, end));
                cells.get(start).setType(CellType.ladder);
            }

            int numberOfPlayers = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < numberOfPlayers; i++) {
                String playerName = sc.nextLine();
                players.put(playerName, new Player(playerName, 0));
            }

            game.setBoard(board);
            game.setLadders(ladders);
            game.setSnakes(snakes);
            game.setPlayers(players);
        }

        return game;*/
        return generateDefaultGameConfig();
    }

    private Game generateDefaultGameConfig() {
        List<Cell> cells;
        Map<Integer, Snake> snakes;
        Map<Integer, Ladder> ladders;
        Map<String, Player> players;
        Board board;
        players= new HashMap<>(){{
            put("Ishan", new Player("Ishan", 0));
            put("Ayush", new Player("Ayush", 0));
            put("Ritesh", new Player("Ritesh", 0));
            put("Nishant", new Player("Nishant", 0));
        }};
        ladders= new HashMap<>(){{
            put(2, new Ladder(2, 37));
            put(27, new Ladder(27, 46));
            put(10, new Ladder(10, 32));
            put(51, new Ladder(51, 68));
            put(61, new Ladder(61, 79));
            put(65, new Ladder(65, 84));
            put(71, new Ladder(71, 91));
            put(81, new Ladder(81, 93));
        }};

        snakes= new HashMap<>(){{
            put(62, new Snake(62, 5));
            put(33, new Snake(33, 6));
            put(49, new Snake(49, 9));
            put(88, new Snake(88, 1));
            put(41, new Snake(41, 2));
            put(56, new Snake(56, 5));
            put(98, new Snake(98, 6));
            put(93, new Snake(93, 7));
            put(95, new Snake(95, 7));
        }};
        cells= new ArrayList<>();
        for(int i=0; i<100; i++){
            if(snakes.containsKey(i)){
                cells.add(new Cell(i, CellType.snake));
            }
            else if(ladders.containsKey(i)){
                cells.add(new Cell(i, CellType.ladder));
            }
            else{
                cells.add(new Cell(i, CellType.empty));
            }
        }
        board= new Board(cells);
        return new Game(snakes, ladders, cells, players, board);
    }

    public Game getGame() {
        return game;
    }
}
