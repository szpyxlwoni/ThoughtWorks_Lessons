package player;

import common.Constant;

public class Player {
    private Integer position;
    private String name;
    private Integer money;

    public Player(int position, int money) {
        this.position = position;
        this.money = money;
    }

    public void move(int moveNumber) {
        position += moveNumber;
        position = position % Constant.LAND_SIZE;
    }

    public boolean deduct(int fine) {
        money -= fine;
        if (money < 0) {
            return false;
        }
        return true;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Integer getMoney() {
        return money;
    }
}
