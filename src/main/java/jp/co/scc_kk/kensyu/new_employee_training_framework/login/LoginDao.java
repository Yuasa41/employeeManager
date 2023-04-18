package jp.co.scc_kk.kensyu.new_employee_training_framework.login;

import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ログイン処理用のDBアクセスを行います。
 * 
 * @author atsutaka-yuasa
 *
 */
@RegisterMapperFactory(BeanMapperFactory.class)
public class LoginDao {

    String database = "jdbc:postgresql://localhost:5432/training";
    String user = "training";
    String pass = "training";


    final String SQL_LOGIN =
            "SELECT users.id as id,slaves.slavename as name,users.authlevel as auth FROM slaves JOIN users ON users.id = slaves.slavenum WHERE users.id = ?  and users.password = ?";

    /**
     * ユーザのログイン認証を行います。
     * 
     * @param id ユーザID
     * @param password パスワード
     * @return ログインユーザ情報
     * @throws SQLException
     */
    public LoginUserData search(int id, String password) throws SQLException {

        // DB接続
        Connection conn = DriverManager.getConnection(database, user, pass);
        try {
            conn = DriverManager.getConnection(database, user, pass);
        } catch (SQLException ex) {

            // DB接続失敗
            System.out.println("コネクションを取得できませんでした。");
            conn.close();
        }


        // 入力情報をSQLへバインド
        PreparedStatement ps = conn.prepareStatement(SQL_LOGIN);

        // ユーザID
        ps.setInt(1, id);

        // パスワード
        ps.setString(2, password);

        // 検索結果
        ResultSet rs = ps.executeQuery();

        // ユーザ情報を取得
        LoginUserData loginUserData = new LoginUserData();

        while (rs.next()) {

            // ユーザID
            loginUserData.setUserId(rs.getInt("id"));
            // パスワード
            loginUserData.setUserName(rs.getString("name"));
            // 権限コード
            loginUserData.setAuthority(rs.getInt("auth"));

        }

        // FIXME デバッグ用コンソール表示
        System.out.println("ユーザID：" + loginUserData.userId);

        System.out.println("ユーザ名：" + loginUserData.userName);

        System.out.println("権限コード：" + loginUserData.authority);

        return loginUserData;
    }

}
