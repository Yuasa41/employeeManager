package jp.co.scc_kk.kensyu.new_employee_training_framework.login;

import spark.ModelAndView;
import spark.Request;

import java.sql.SQLException;
import java.util.Map;

// 明日やること
// 実行確認

public class LoginLogic {

    static loginCheck lc = new loginCheck();

    public static ModelAndView login(Map<String, Object> model, Request request) {

        // 入力値を受け取る
        System.out.println("hello");

        final int USER_ID = Integer.parseInt(request.queryParams("userId"));
        final String PASSWORD = request.queryParams("password");

        search(USER_ID, PASSWORD);
        System.out.println(USER_ID);
        System.out.println(PASSWORD);

        // のちのちののちのち
        // model.put("userId", USER_ID);
        // model.put("password", PASSWORD);

        return new ModelAndView(model, "finishedLoin");
    }

    /**
     * 指定した社員番号の社員情報を標準出力に出力する
     *
     * @param employeeNumber 社員番号
     */
    public static void search(int id, String pass) {

        try {
            // EmployeeEntity entity = dao.search(Integer.parseInt(employeeNumber));
            databaseEntity entity = lc.search(id, pass);

        } catch (NumberFormatException ex) {
            System.out.println("第2引数には数値を入力してください");
        } catch (SQLException ex) {
            System.out.println("データベースコネクションエラーが発生しました");
        }
    }

}
