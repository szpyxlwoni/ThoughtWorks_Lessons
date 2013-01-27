package output;

import org.junit.Test;
import ouput.MessageOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MessageOutputTest {
    @Test
    public void should_show_text_message_in_screen() {
        try {
            PrintStream standOut = System.out;
            System.setOut(new PrintStream("/Users/twer/IdeaProjects/Rich/src/test/java/output/output"));
            MessageOutput messageOutput = new MessageOutput();
            messageOutput.showText("aaa");
            FileInputStream fileInputStream = new FileInputStream("/Users/twer/IdeaProjects/Rich/src/test/java/output/output");
            Scanner actual = new Scanner(fileInputStream);
            assertThat(actual.next(), is("aaa"));
            System.setOut(standOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
