package common;

import java.io.Serializable;

/*
* 用戶信息
* */
public class User implements Serializable {

    private static final long serialVersionUID = 1L; //增强兼容性

    private String userId;  //用戶名
    private String passwd;   //密碼

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public User(){

    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
