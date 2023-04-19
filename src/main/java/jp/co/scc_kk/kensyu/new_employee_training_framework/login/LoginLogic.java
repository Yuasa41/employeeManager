package jp.co.scc_kk.kensyu.new_employee_training_framework.login;

import spark.ModelAndView;
import spark.Request;

import java.sql.SQLException;
import java.util.Map;

/**
 * ログイン処理のロジックです。
 * 
 * @author atsutaka-yuasa
 *
 */

public class LoginLogic {


    static LoginDao loginDao = new LoginDao();

    public static ModelAndView login(Map<String, Object> model, Request request) {

        // 入力値を受け取る
        final int USER_ID = Integer.parseInt(request.queryParams("userId"));
        final String PASSWORD = request.queryParams("password");


        if (search(USER_ID, PASSWORD, request)) {
            // 認証成功時

            // モデルにセッションの値を設定
            model.put("loginUser", request.session().attribute("loginUser").toString());
            model.put("loginUserName", request.session().attribute("loginUserName").toString());
            model.put("userAuth", request.session().attribute("userAuth").toString());

            return new ModelAndView(model, "index");
        } else {
            // 認証失敗時
            return new ModelAndView(model, "login");
        }
    }

    /**
     * 指定した社員番号の社員情報を標準出力に出力する
     *
     * @param employeeNumber 社員番号
     */
    public static boolean search(int id, String pass, Request request) {

        try {
            // 誰がログインしたのかを確認
            LoginUserData loginUserData = loginDao.search(id, pass);

            // ログイン可否
            if (loginUserData.getUserName() != null) {
                // ログイン成功

                // ログイン情報をセッションに格納
                request.session().attribute("loginUser", loginUserData.getUserId());
                request.session().attribute("loginUserName", loginUserData.getUserName());
                request.session().attribute("userAuth", loginUserData.getAuthority());

                return true;
            } else {
                // ログイン失敗
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
