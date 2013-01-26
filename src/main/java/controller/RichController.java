package controller;

import common.Constant;
import land.Land;
import landImpl.*;
import player.Player;

import java.util.ArrayList;

public class RichController {
    private ArrayList<Land> lands;
    private ArrayList<Player> players;
    private Integer currentPlayer = 0;

    public void initLands() {
        lands = new ArrayList<Land>();
        initStart();
        initAreaOneOrTwo();
        initAreaOneOrTwo();
        initAreaThree();
        initAreaFourOrFive();
        initAreaFourOrFive();
    }

    private void initStart() {
        for (int i = 0; i < 12; i++) {
            Land land = new StartLand();
            lands.add(land);
        }
    }

    private void initAreaFourOrFive() {
        for (int i = 0; i < Constant.AREA_SIZE; i++) {
            Land land = new BuildingLand(Constant.AREA_FOUR_OR_FIVE_VALUE);
            lands.add(land);
        }
    }

    private void initAreaThree() {
        for (int i = 0; i < Constant.HOT_AREA_SIZE; i++) {
            Land land = new BuildingLand(Constant.AREA_THREE_VALUE);
            lands.add(land);
        }
    }

    private void initAreaOneOrTwo() {
        for (int i = 0; i < Constant.AREA_SIZE; i++) {
            Land land = new BuildingLand(Constant.AREA_ONE_OR_TWO_VALUE);
            lands.add(land);
        }
    }

    public Integer getLandSize() {
        return this.lands.size();
    }

    public void initPlayers(int playerNumber) {
        players = new ArrayList<Player>();
        for (int i = 0; i < playerNumber; i++) {
            Player player = new Player(Constant.START_POSITION, 10000);
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