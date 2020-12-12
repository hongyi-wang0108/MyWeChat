package com.example.mywechat;

public class MyMsg {

    int type;
    String content;
    static final int TYPE_RIGHT_SEND = 1;
    static final int TYPE_LEFT_RECIVER = 2;


    public MyMsg(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
