package client.service;

import common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{
    //該綫程需要持有socket
    private Socket socket;

    //創建構造器
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //綫程需要在後臺和服務器通訊，因此使用while循環
        while(true){
            System.out.println("Client Thread waiting for messages...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();   //如果伺服器沒有傳送Message對象，綫程會阻塞
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
