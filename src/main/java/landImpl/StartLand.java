package landImpl;

import common.Message;
import common.TextOnlyMessage;
import land.Land;
import player.Player;

public class StartLand implements Land {
    @Override
    public Message getStatus(Player player) {
        Message message = new TextOnlyMessage("这里是起点");
        return message;
    }

    @Override
    public Message doLandAction(Player player) {
        Message message = new TextOnlyMessage("没有任何动作");
        return message;
    }
}
