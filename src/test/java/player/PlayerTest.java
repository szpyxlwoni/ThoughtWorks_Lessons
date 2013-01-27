package player;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    private Player player;

    @Before
    public void set_up() {
        player = new Player(0, 10000);
    }

    @Test
    public void should_move() {
        player.move(6);
        assertThat(player.getPosition(), is(6));
    }

    @Test
    public void should_deduct_player_money() {
        player.deduct(200);
        assertThat(player.getMoney(), is(9800));
    }
}
