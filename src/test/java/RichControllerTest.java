import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class RichControllerTest {

    private RichController controller;

    @Before
    public void set_up() {
        controller = new RichController();
        controller.initLands();
        controller.initPlayers(2);
    }

    @Test
    public void should_init_lands() {
        assertThat(controller.getLandSize(), is(70));
    }

    @Test
    public void should_init_players() {
        assertThat(controller.getPlayerSize(), is(2));
    }

    @Test
    public void should_roll_a_random_number() {
        int randomNumber = controller.roll();
        assertThat(randomNumber >= 1 && randomNumber <= 6, is(Boolean.TRUE));
    }

    @Test
    public void should_get_current_players() {
        Player prevPlayer = controller.getCurrentPlayer();
        controller.changePlayer();
        assertThat(controller.getCurrentPlayer(), not(prevPlayer));
    }
}
