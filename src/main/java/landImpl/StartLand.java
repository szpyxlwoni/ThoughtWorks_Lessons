package landImpl;

import common.Message;
import land.Land;
import player.Player;

public class StartLand implements Land {
    private Message message;

    public StartLand() {
        this.message = new Message();
        message.setType(0);
    }

    @Override
    public Message getStatus(Player player) {
        return message;
    }

    @Override
    public Message execute(Player player) {
        return message;
    }
}
