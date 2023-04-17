package jp.co.scc_kk.kensyu.new_employee_training_framework.login;

import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 佐藤陽亮
 */
@RegisterMapperFactory(BeanMapperFactory.class)
public class loginCheck {

    String database = "jdbc:postgresql://localhost:5432/training";
    String user = "training";
    String pass = "training";

    public databaseEntity search(int id, String password) throws SQLException {

        // ↓↓↓ DBに接続する例 ↓↓↓
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(database, user, pass); // 「DBに接続する例」①
        } catch (SQLException ex) {// 「DBに接続する例」②
            System.out.println("コネクションを取得できませんでした。");
            conn.close();
        }
        // ↑↑↑ DBに接続する例 ↑↑↑

        // ↓↓↓ DBを参照する例 ↓↓↓
        // String sql = "select * from employees where empno = ?";// 「DBを参照する例」①
        String sql = "select slaves.slavename from users,slaves" + " where users.id = slaves.slavenum"
                + "and users.id = ?" + "and users.password = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(1, password);
        ResultSet rs = ps.executeQuery(); // 「DBを参照する例」②③

        // データ取得
        databaseEntity de = new databaseEntity();

        while (rs.next()) { // 「DBを参照する例」④
            de.setSlaveName(rs.getString("slavename")); // 「DBを参照する例」⑤
        }
        // ↑↑↑ DBに接続する例 ↑↑↑

        return de;
    }

}
