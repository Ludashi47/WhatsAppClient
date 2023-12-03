package client.service;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 * 完成用戶登錄驗證和用戶注冊
 */

public class UserClientService {
    //可能在其他地方使用user信息，所以要做成成員屬性
    private User u = new User();
    //Socket在其他地方會用到，所以需要提前創建
    private Socket socket = null;

    //驗證用戶是否合法
    public boolean checkUser(String userId, String userPwd){
        u.setUserId(userId);
        u.setPasswd(userPwd);
        //連接到伺服器，發送u對象
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //得到ObjectOutput對象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u); //發送u對象

            //讀取從伺服端互動的Message對象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                System.out.println("Login Succeed.");
                //創建 和伺服器保持聯絡的綫程 -> 創建一個類 ClientConnectServerThread
                //

            }else {
                System.out.println("Login failed.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
   }
}
