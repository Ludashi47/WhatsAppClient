package client.service;

import java.util.HashMap;

/**
 * 管理客戶端和伺服器端保持通訊的綫程的類
 */

public class ManageClientConnectServerThread {
    //將 綫程放入集合 key為userId，value為綫程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    //將某個客戶端的綫程加入到集合中
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread ccst){
        hm.put(userId, ccst);
    }

    //可以通過userId取得對應的綫程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }
}

