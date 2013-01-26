package land;

import common.Message;
import player.Player;

public interface Land {
    Message getStatus(Player player);
    Message execute(Player player);
}
