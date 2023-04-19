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

    final String SQL_SEARCH_LIST =
            "SELECT slavenum,slavename,dep.deptname AS deptname FROM slaves AS sl JOIN departments AS dep ON sl.slavedept=dep.deptno;";
    final String SQL_INSERT_ONE = "INSERT INTO slaves(slavenum,slavename,slavedept) VALUES(?,?,?);";

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
            employeeData.setDepartmentName(rs.getString("deptname"));



            employeeEntity.appendList(employeeData);

        }

        return employeeEntity;
    }

    public boolean insert(EmployeeData employeeData) throws SQLException {

        // DB接続
        Connection conn = DriverManager.getConnection(database, user, pass);
        try {
            conn = DriverManager.getConnection(database, user, pass);
        } catch (SQLException ex) {

            // DB接続失敗
            System.out.println("コネクションを取得できませんでした。");
            conn.close();
        }

        PreparedStatement ps = conn.prepareStatement(SQL_INSERT_ONE);
        ps.setInt(1, employeeData.getEmployeeId());
        ps.setString(2, employeeData.getEmployeeName());
        ps.setInt(3, employeeData.getDepartmentId());

        int result = ps.executeUpdate();

        if (result <= 0) {
            return false;
        }

        return true;
    }

}
