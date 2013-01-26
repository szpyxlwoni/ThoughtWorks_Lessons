package landImpl;

import common.Message;
import org.junit.Test;
import player.Player;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HospitalTest {
    @Test
    public void should_get_type_0_message() {
        Hospital hospital = new Hospital();
        Player player = new Player(0, 10000);
        Message message = hospital.getStatus(player);
        assertThat(message.getType(), is(0));
    }
}
