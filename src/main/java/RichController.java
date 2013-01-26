import java.util.ArrayList;

public class RichController {
    private ArrayList<Land> lands;
    private ArrayList<Player> players;
    private int currentPlayer = 0;

    public void initLands() {
        lands = new ArrayList<Land>();
        for (int i = 0; i < Constant.LAND_SIZE; i++) {
            Land land = new BuildingLand();
            lands.add(land);
        }
    }

    public Integer getLandSize() {
        return this.lands.size();
    }

    public void initPlayers(int playerNumber) {
        players = new ArrayList<Player>();
        for (int i = 0; i < playerNumber; i++) {
            Player player = new Player(Constant.START_POSITION);
            players.add(player);
        }
    }

    public Integer getPlayerSize() {
        return this.players.size();
    }

    public void rollAndMove() {
        Player currentPlayer = getCurrentPlayer();
        currentPlayer.move(roll());
    }

    public Integer roll() {
        Double random = Math.random() * 1000;
        return random.intValue() % Constant.ROLL_SIZE + 1;
    }

    public void changePlayer() {
         currentPlayer++;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }
}
