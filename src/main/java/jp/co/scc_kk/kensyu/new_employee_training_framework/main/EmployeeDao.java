package jp.co.scc_kk.kensyu.new_employee_training_framework.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 社員管理機能のDB処理を行います。
 * 
 * @author atsutaka-yuasa
 *
 */
public class EmployeeDao {
    String database = "jdbc:postgresql://localhost:5432/training";
    String user = "training";
    String pass = "training";

    final String SQL_SEARCH_LIST = "SELECT * FROM slaves;";

    public EmployeeEntity search(EmployeeEntity employeeEntity) throws SQLException {

        // DB接続
        Connection conn = DriverManager.getConnection(database, user, pass);
        try {
            conn = DriverManager.getConnection(database, user, pass);
        } catch (SQLException ex) {

            // DB接続失敗
            System.out.println("コネクションを取得できませんでした。");
            conn.close();
        }

        PreparedStatement ps = conn.prepareStatement(SQL_SEARCH_LIST);

        ResultSet rs = ps.executeQuery();



        while (rs.next()) {
            EmployeeData employeeData = new EmployeeData();

            employeeData.setEmployeeId(rs.getInt("slavenum"));
            employeeData.setEmployeeName(rs.getString("slavename"));
            employeeData.setDepartmentId(rs.getInt("slavedept"));

            employeeEntity.appendList(employeeData);

        }

        return employeeEntity;
    }

}
