package common;

import java.util.ArrayList;

public abstract class Message {
    private final String content;
    private Object newObject;
    private ArrayList arrayList;

    protected Message(String content) {
        this.content = content;
    }

    public abstract void exeMessage();

    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public Object getNewObject() {
        return newObject;
    }

    public void setNewObject(Object newObject) {
        this.newObject = newObject;
    }


    public String getContent() {
        return content;
    }
}
