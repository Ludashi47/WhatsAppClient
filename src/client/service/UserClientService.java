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
        boolean b = false;  //用於 函數返回
        u.setUserId(userId);
        u.setPasswd(userPwd);
        //連接到伺服器，發送u對象
        try {
            /*
            * 與 伺服器 進行連接，驗證用戶合法性
            * */
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //得到ObjectOutput對象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u); //發送u對象

            //讀取從伺服端互動的Message對象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){  //成功登入
                b = true;
                System.out.println("Login Succeed.");
                //創建 和伺服器保持聯絡的綫程 -> 創建一個類 ClientConnectServerThread
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                //啟動該綫程:與伺服器一直保持通訊
                ccst.start();
                //爲了後續 客戶端的擴展性，將綫程放入集合管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId, ccst);

            }else {
                System.out.println("Login failed.");
                //關閉socket
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return b;
   }
}
