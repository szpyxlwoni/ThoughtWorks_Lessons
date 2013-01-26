package landImpl;

import common.Message;
import land.Land;
import org.junit.Before;
import org.junit.Test;
import player.Player;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BuildingLandTest {
    private Land buildingLand;
    private Player player;
    private Player otherPlayer;

    @Before
    public void set_up() {
        buildingLand = new BuildingLand(200);
        player = new Player(0, 10000);
        otherPlayer = new Player(0, 10000);
    }

    @Test
    public void should_minus_non_owner_money_when_it_arrived_that_land() {
        buildingLand.execute(player);
        buildingLand.execute(otherPlayer);
        assertThat(otherPlayer.getMoney(), is(9900));
    }

    @Test
    public void should_return_false_if_player_money_is_minus() {
        otherPlayer = new Player(0, 50);
        buildingLand.execute(player);
        Message message = buildingLand.execute(otherPlayer);
        assertThat(message.getContent(), is("你破产了"));
    }

    @Test
    public void should_let_player_become_owner_when_it_been_first_landed() {
        Message message = buildingLand.execute(player);
        assertThat(message.getContent(), is("购买成功"));
    }

    @Test
    public void should_level_up_when_owner_land_again() {
        buildingLand.execute(player);
        Message message = buildingLand.execute(player);
        assertThat(message.getContent(), is("升级成功"));
    }

    @Test
    public void should_return_ask_message_for_buy() {
        Message message = buildingLand.getStatus(player);
        assertThat(message.getContent(), is("是否购买该处空地，200元（Y/N）?"));
    }

    @Test
    public void should_return_ask_message_for_level_up() {
        buildingLand.execute(player);
        Message message = buildingLand.getStatus(player);
        assertThat(message.getContent(), is("是否升级该处地产，200元（Y/N）?"));
    }

    @Test
    public void should_return_a_message_if_can_not_level_up() {
        buildingLand.execute(player);
        buildingLand.execute(player);
        buildingLand.execute(player);
        Message message = buildingLand.getStatus(player);
        assertThat(message.getContent(), is("无法再升级该处"));
    }

    @Test
    public void should_return_warning_message_if_a_player_land_others_land() {
        buildingLand.execute(player);
        Message message = buildingLand.getStatus(otherPlayer);
        assertThat(message.getContent(), is("该处为" + player.getName() + "所有，你已扣除100元"));
    }
}
