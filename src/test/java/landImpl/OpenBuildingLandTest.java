package landImpl;

import common.AlertMessage;
import common.ChangeObjectMessage;
import common.Message;
import common.PlayerBreakMessage;
import land.Land;
import org.junit.Before;
import org.junit.Test;
import player.Player;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OpenBuildingLandTest {

    private Player player;
    private Land land;

    @Before
    public void set_up() {
        player = new Player(0, 10000);
        land = new OpenBuildingLand(200);
    }

    @Test
    public void should_get_alert_message_when_get_status() {
        Message message = land.getStatus(player);
        assertThat(message, is(AlertMessage.class));
    }

    @Test
    public void should_get_change_object_message_when_do_land_action() {
        Message message = land.doLandAction(player);
        assertThat(message, is(ChangeObjectMessage.class));
    }

    @Test
    public void should_get_player_break_message_when_player_break() {
        player = new Player(0, 100);
        Message message = land.doLandAction(player);
        assertThat(message, is(PlayerBreakMessage.class));
    }
}
