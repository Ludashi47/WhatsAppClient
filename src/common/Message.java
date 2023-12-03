package common;

/*
* 客戶端和伺服器端 通信時的 消息對象
* */

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L; //增强兼容性
    private String sender;  //發送者
    private String receiver; //接收者
    private String content; //消息内容
    private String sendTime;    //發送時間
    private String mesType; //消息類型[可以在接口中定義]


    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
