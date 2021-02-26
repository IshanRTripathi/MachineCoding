package snakesAndLadders;


import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void checkGameStatus(){
        assert(!new Game().isGameOver());
    }
}