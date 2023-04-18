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
        final int USER_ID = Integer.parseInt(request.queryParams("userId"));
        final String PASSWORD = request.queryParams("password");


        System.out.println(USER_ID);
        System.out.println(PASSWORD);

        // のちのちののちのち
        // model.put("userId", USER_ID);
        // model.put("password", PASSWORD);
        if (search(USER_ID, PASSWORD)) {
            return new ModelAndView(model, "finishedLogin");
        } else {
            return new ModelAndView(model, "login");
        }
    }

    /**
     * 指定した社員番号の社員情報を標準出力に出力する
     *
     * @param employeeNumber 社員番号
     */
    public static boolean search(int id, String pass) {

        try {
            // EmployeeEntity entity = dao.search(Integer.parseInt(employeeNumber));
            databaseEntity entity = lc.search(id, pass);
            System.out.println(entity.getSlaveName());

            // ログインできるかどうか
            if (entity.getSlaveName() != null) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            System.out.println("第2引数には数値を入力してください");
            return false;
        } catch (SQLException ex) {
            System.out.println("データベースコネクションエラーが発生しました");
            return false;
        }
    }

}
