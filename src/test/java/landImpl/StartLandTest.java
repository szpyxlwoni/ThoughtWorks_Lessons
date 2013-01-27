package landImpl;

import common.Message;
import common.TextOnlyMessage;
import land.Land;
import org.junit.Before;
import org.junit.Test;
import player.Player;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartLandTest {

    private StartLand startLand;
    private Player player;

    @Before
    public void set_up() {
        this.startLand = new StartLand();
        this.player = new Player(0, 10000);
    }

    @Test
    public void should_get_text_only_message_when_get_status() {
        Message message = startLand.getStatus(player);
        assertThat(message, is(TextOnlyMessage.class));
    }

    @Test
    public void should_get_text_only_message_when_do_land_action() {
        Message message = startLand.doLandAction(player);
        assertThat(message, is(TextOnlyMessage.class));
    }
}
