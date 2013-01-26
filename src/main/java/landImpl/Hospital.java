package landImpl;

import common.Message;
import land.Land;
import player.Player;

public class Hospital implements Land {
    private Message message;

    public Hospital() {
        message = new Message();
        message.setType(0);
        message.setContent(null);
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
