package client.view;

import client.service.UserClientService;
import client.util.Utility;

/**
 * 客戶端的菜單界面
 */
public class View {
    private boolean loop = true;    //控制是否顯示菜單
    private String key = "";    //接收鍵盤輸入
    private UserClientService ucs = new UserClientService();    //用於登入伺服器

    public static void main(String[] args) {
        new View().mainMenu();
    }

    private void mainMenu(){
        while(loop){
            System.out.println("================Login WhatsApp================");
            System.out.println("\t\t 1 Login");
            System.out.println("\t\t 9 Exit");
            System.out.println("Input your command： ");
            key = Utility.readString(1);

            // 接收鍵盤輸入
            switch (key){
                case "1":
                    System.out.println("!!Log in!!");
                    System.out.print("Enter userId: ");
                    String userId = Utility.readString(50);
                    System.out.print("Enter userPwd: ");
                    String userPwd = Utility.readString(50);

                    //此處要到伺服器端驗證用戶合法性
                    //編寫UserClientService
                    if(ucs.checkUser(userId,userPwd)){   //登入成功
                        //對id和pwd進行驗證之後
                        System.out.println("================Welcome "+ userId+" ================");
                        //進入二級菜單
                        while(loop){
                            System.out.println("================WhatsApp SecondaryMenu("+userId+")================");
                            System.out.println("\t\t 1 Display Online Users");
                            System.out.println("\t\t 2 Group Chat");
                            System.out.println("\t\t 3 Side-text Chat");
                            System.out.println("\t\t 4 Send File");
                            System.out.println("\t\t 9 Exit");
                            System.out.print("Enter your command: ");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    System.out.println("Online Users");
                                    break;
                                case "2":
                                    System.out.println("Group Chat");
                                    break;
                                case "3":
                                    System.out.println("Side-text");
                                    break;
                                case "4":
                                    System.out.println("File Sender:");
                                    break;
                                case "9":
                                    loop=false;
                                    break;
                            }
                        }
                    }else{  //登入失敗
                        System.out.println("!Failed to login!");
                    }

                    break;
                case "9":
                    System.out.println("退出系統");
                    loop = false;
                    break;
            }
        }
    }
}
