public class Player {
    private Integer position;
    private String name;

    public Player(int position) {
        this.position = position;
    }

    public void move(int moveNumber) {
        position += moveNumber;
        position = position % Constant.LAND_SIZE;
    }

    public Integer getPosition() {
        return position;
    }
}
