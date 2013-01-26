import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    @Test
    public void should_move() {
        Player player = new Player(0);
        player.move(6);
        assertThat(player.getPosition(), is(6));
    }
}
