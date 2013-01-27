package common;

import player.Player;

public class PlayerBreakMessage extends Message {
    public PlayerBreakMessage(String content, Player player) {
        super(content);
    }

    @Override
    public void exeMessage() {
        System.out.println(getContent());
    }
}
