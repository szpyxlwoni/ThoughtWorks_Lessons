package common;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TextOnlyMessageTest {
    @Test
    public void should_execute_message() {
        Message message = new TextOnlyMessage("升级成功");
        message.exeMessage();
        assertThat(message.getContent(), is("升级成功"));
    }
}
