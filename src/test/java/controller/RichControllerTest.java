package controller;

import common.Constant;
import controller.RichController;
import land.Land;
import org.junit.Before;
import org.junit.Test;
import player.Player;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class RichControllerTest {

    private RichController controller;

    @Before
    public void set_up() {
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < 2; i++) {
            Player player = new Player("Test", 0, 10000);
            players.add(player);
        }
        controller = new RichController(players);
        controller.initLands();
    }

    @Test
    public void should_init_lands() {
        assertThat(controller.getLandSize(), is(Constant.LAND_SIZE));
    }

    @Test
    public void should_init_players() {
        assertThat(controller.getPlayerSize(), is(2));
    }

    @Test
    public void should_roll_a_random_number() {
        int randomNumber = controller.roll();
        assertThat(randomNumber >= 1 && randomNumber <= Constant.ROLL_SIZE, is(Boolean.TRUE));
    }

    @Test
    public void should_get_current_players() {
        Player prevPlayer = controller.getCurrentPlayer();
        controller.changePlayer();
        assertThat(controller.getCurrentPlayer(), not(prevPlayer));
    }

    @Test
    public void should_get_land() {
        Land prevLandOfCurrentPlayer = controller.getCurrentLandOfCurrentPlayer();
        controller.rollAndMove();
        assertThat(controller.getCurrentLandOfCurrentPlayer(), not(prevLandOfCurrentPlayer));
    }
}
