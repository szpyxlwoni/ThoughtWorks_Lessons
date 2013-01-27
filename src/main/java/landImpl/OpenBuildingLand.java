package landImpl;

import common.AlertMessage;
import common.ChangeObjectMessage;
import common.Message;
import land.BuildingLand;
import player.Player;

public class OpenBuildingLand extends BuildingLand {

    public OpenBuildingLand(int value) {
        super(value);
    }

    @Override
    public Message getStatus(Player player) {
        Message message = new AlertMessage("是否购买该处空地，" + getValue() + "元（Y/N）?");
        return message;
    }

    @Override
    public Message doLandAction(Player player) {
        Message message = new ChangeObjectMessage("升级成功");
        message.setNewObject(new SimpleBuildingLand(getValue()));
        player.deduct(getValue());
        return message;
    }
}
