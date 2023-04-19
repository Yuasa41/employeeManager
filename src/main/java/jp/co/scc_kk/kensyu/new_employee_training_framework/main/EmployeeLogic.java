package jp.co.scc_kk.kensyu.new_employee_training_framework.main;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

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

    public static ModelAndView registOne(Map<String, Object> model, Request request, Response response)
            throws SQLException {
        final int EMPLOYEE_ID = Integer.parseInt(request.queryParams("employeeId"));
        final String EMPLOYEE_NAME = request.queryParams("employeeName");
        final int DEPARTMENT_ID = Integer.parseInt(request.queryParams("departmentName"));

        EmployeeData employeeData = new EmployeeData();
        employeeData.setEmployeeId(EMPLOYEE_ID);
        employeeData.setEmployeeName(EMPLOYEE_NAME);

        employeeData.setDepartmentId(DEPARTMENT_ID);

        employeeDao.insert(employeeData);

        response.redirect("/employee/search");

        return new ModelAndView(model, "search");

    }

    public void registCsv() {

    }

    public void updateOne() {

    }

    public void deleteOne(int employeeId) {

    }

}
