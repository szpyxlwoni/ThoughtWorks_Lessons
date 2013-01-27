package common;

public class AlertMessage extends Message {
    public AlertMessage(String content) {
        super(content);
    }

    @Override
    public void exeMessage() {
        System.out.println(getContent());
    }
}
