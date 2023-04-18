package jp.co.scc_kk.kensyu.new_employee_training_framework.main;

import spark.ModelAndView;

import java.sql.SQLException;
import java.util.Map;

/**
 * 社員情報管理ロジックです。
 * 
 * @author atsutaka-yuasa
 *
 */

public class EmployeeLogic {

    static EmployeeDao employeeDao = new EmployeeDao();


    public static ModelAndView search(Map<String, Object> model) {

        EmployeeEntity employeeEntity = new EmployeeEntity();

        try {
            employeeEntity = employeeDao.search(employeeEntity);
            model.put("employeeList", employeeEntity.employeeList);

            for (EmployeeData data : employeeEntity.employeeList) {
                data.info();
            }
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }


        return new ModelAndView(model, "search");

    }

    public void searchOne() {

    }

    public void registOne() {

    }

    public void registCsv() {

    }

    public void updateOne() {

    }

    public void deleteOne(int employeeId) {

    }

}
