package snakesAndLadders.service;


import snakesAndLadders.Game;
import snakesAndLadders.models.Board;
import snakesAndLadders.models.CellType;
import snakesAndLadders.models.Player;

/*
1. roll dice
2. update player position
3. check if game is over
4.
*/
public class GameManager {

    Board board;
    Game game;

    public GameManager(Game game, Board board) {
        this.board= board;
        this.game= game;
    }

    public void playTurn(Player player) {
        int diceValue= getDiceRollValue();
        String playerName= player.getPlayerName();
        int currentPosition= player.getCurrentPosition();

        int newPlayerPosition= currentPosition+diceValue;

        System.out.println("\t\t\t\t\t\t\t\t\tDice Value :"+diceValue);

        System.out.println(playerName+" jumps from "+currentPosition+" to "+ (Math.min(newPlayerPosition, 100)));
        player.setCurrentPosition(newPlayerPosition);
        Game.isGameOver = checkIfPlayerWins(player);
        if(!Game.isGameOver) {
            updatePlayerPosition(player);
            Game.isGameOver = checkIfPlayerWins(player);
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
        CellType cellType= board.getCells().get(currentPlayerPosition).getType();

        switch (cellType) {
            case snake -> {
                newPlayerPosition = game.getSnakes().get(currentPlayerPosition).getTail();
                System.out.print(player.getPlayerName() + " bit by a snake ");
            }
            case ladder -> {
                newPlayerPosition = game.getLadders().get(currentPlayerPosition).getEnd();
                System.out.print(player.getPlayerName() + " takes a stair ");
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
}
