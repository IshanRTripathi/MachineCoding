package snakesAndLadders.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import snakesAndLadders.Game;
import snakesAndLadders.models.*;

import java.util.List;
import java.util.Map;

public class GameManagerTest {
    private static List<Cell> cells;
    private static Map<Integer, Snake> snakes;
    private static Map<Integer, Ladder> ladders;
    private static Map<String, Player> players;
    static Board board;
    static Game game;
    static GameManager manager;

    @BeforeAll
    public static void initialiseFields(){
        manager= new GameManager();
        game= manager.getGame();
        board= game.getBoard();
        cells= game.getCells();
        snakes= game.getSnakes();
        ladders= game.getLadders();
        players= game.getPlayers();
    }

    @Test
    public void testCheckValidObjects(){
        assert(manager!=null);
        assert(game!=null);
        assert(snakes.size()!=0);
        assert(ladders.size()!=0);
        assert(board!=null);
    }

    @Test
    public void testValidSnakes(){
        for(Snake snake: snakes.values()){
            assert(snake.getHead()>snake.getTail());
        }
    }

    @Test
    public void testValidLadders(){
        for(Ladder ladder: ladders.values()){
            assert (ladder.getStart() < ladder.getEnd());
        }
    }
}