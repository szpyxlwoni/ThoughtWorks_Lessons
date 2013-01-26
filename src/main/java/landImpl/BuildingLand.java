package landImpl;

import common.Message;
import land.Land;
import player.Player;

public class BuildingLand implements Land {
    private Message message;
    private final int value;
    private int level;
    private Player owner;

    public BuildingLand(int value) {
        message = new Message();
        this.value = value;
    }

    @Override
    public Message getStatus(Player player) {
        if (level == 0) {
            message.setType(1);
            message.setContent("是否购买该处空地，" + value + "元（Y/N）?");
        }
        if (level != 0 && player != owner) {
            message.setType(0);
            message.setContent("该处为" + player.getName() + "所有，你已扣除" + getFine() + "元");
        }
        if (level != 0 && player == owner) {
            message.setType(1);
            message.setContent("是否升级该处地产，" + value + "元（Y/N）?");
        }
        if (level >= 3) {
            message.setType(0);
            message.setContent("无法再升级该处");
        }
        return message;
    }

    private int getFine() {
        return value * level / 2;
    }

    @Override
    public Message execute(Player player) {
        if (level == 0) {
            owner = player;
            level++;
            message.setContent("购买成功");
        } else if (player != owner) {
            if (!player.deduct(getFine())) {
                message.setType(3);
                message.setContent("你破产了");
            }else {
                message.setType(1);
            }
        } else if (level < 3) {
            level++;
            message.setContent("升级成功");
        }
        return message;
    }
}
