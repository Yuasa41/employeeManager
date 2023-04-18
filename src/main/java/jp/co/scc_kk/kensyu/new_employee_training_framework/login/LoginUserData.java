package jp.co.scc_kk.kensyu.new_employee_training_framework.login;

/**
 * ログインユーザ情報を保存するインスタンスです。
 * 
 * @author atsutaka-yuasa
 *
 */
public class LoginUserData {

    int userId;

    String userName;

    int authority;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }



}
