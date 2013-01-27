package controller;

import common.Constant;
import common.Message;
import land.BuildingLand;
import land.Land;
import landImpl.*;
import player.Player;

import java.util.ArrayList;

public class RichController {
    private ArrayList<Land> lands;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Integer currentPlayer = 0;

    public RichController(ArrayList<Player> players) {
        this.players = players;
    }

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
            Land land = new OpenBuildingLand(Constant.AREA_FOUR_OR_FIVE_VALUE);
            lands.add(land);
        }
    }

    private void initAreaThree() {
        for (int i = 0; i < Constant.HOT_AREA_SIZE; i++) {
            Land land = new OpenBuildingLand(Constant.AREA_THREE_VALUE);
            lands.add(land);
        }
    }

    private void initAreaOneOrTwo() {
        for (int i = 0; i < Constant.AREA_SIZE; i++) {
            Land land = new OpenBuildingLand(Constant.AREA_ONE_OR_TWO_VALUE);
            lands.add(land);
        }
    }

    public Integer getLandSize() {
        return this.lands.size();
    }

    public Integer getPlayerSize() {
        return this.players.size();
    }

    public void rollAndMove() {
        Player currentPlayer = getCurrentPlayer();
        currentPlayer.move(roll());
        Land currentLandOfCurrentPlayer = getCurrentLandOfCurrentPlayer();
        Message message = currentLandOfCurrentPlayer.getStatus(currentPlayer);
        message.exeMessage();
        message = currentLandOfCurrentPlayer.doLandAction(currentPlayer);
        message.exeMessage();
    }

    public Integer roll() {
        Double random = Math.random() * 1000;
        return random.intValue() % Constant.ROLL_SIZE + 1;
    }

    public boolean changePlayer() {
        deleteBreakPlayer();
        currentPlayer++;
        currentPlayer = currentPlayer % players.size();
        if (players.size() == 1) {
            return true;
        }
        return false;
    }

    public void deleteBreakPlayer() {
        if (getCurrentPlayer().getMoney() < 0) {
            players.remove(getCurrentPlayer());
            currentPlayer--;
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public Land getCurrentLandOfCurrentPlayer() {
        return lands.get(getCurrentPlayer().getPosition());
    }
}