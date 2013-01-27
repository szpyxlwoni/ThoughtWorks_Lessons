package land;

import common.Message;
import common.PlayerBreakMessage;
import player.Player;

public abstract class BuildingLand implements Land {
    private final int value;

    private Player owner;

    public BuildingLand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    protected Message deductPlayerMoney(Player player, Message message) {
        return player.deduct(getValue()) ? message : new PlayerBreakMessage("你破产了", player);
    }
}
