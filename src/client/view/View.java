package client.view;

/**
 * 客戶端的菜單界面
 */



public class View {
    private boolean loop = true;    //控制是否顯示菜單
    private String key = "";    //接收鍵盤輸入
    private void mainMenu(){
        while(loop){
            System.out.println("================登錄系統================");
            System.out.println("\t\t 1 登錄系統");
            System.out.println("\t\t 2 退出系統");
        }
    }
}
