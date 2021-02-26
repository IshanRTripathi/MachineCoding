package snakesAndLadders.models;

public class Player {
    private String playerName;
    private int currentPosition;

    public Player(String playerName, int currentPosition) {
        this.playerName= playerName;
        this.currentPosition= currentPosition;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public String toString() {
        return "PlayerName='" + playerName + ", currentPosition=" + currentPosition;
    }
}
