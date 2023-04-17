package jp.co.scc_kk.kensyu.new_employee_training_framework;

import jp.co.scc_kk.kensyu.new_employee_training_framework.login.LoginLogic;
import spark.ModelAndView;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        final ThymeleafTemplateEngine templateEngine = new ThymeleafTemplateEngine();

        // 遷移先テンプレートファイル指定
        Spark.staticFileLocation("/assets");

        // モデル初期化
        Map<String, Object> model = new HashMap<>();

        // ハロー画面に遷移
        Spark.get("/", (request, responce) -> new ModelAndView(model, "index"), templateEngine);
        // ハロー画面に遷移
        Spark.get("/FP01", (request, responce) -> new ModelAndView(model, "hello"), templateEngine);

        // ログイン画面に遷移
        Spark.get("/FP02", (request, responce) -> new ModelAndView(model, "login"), templateEngine);

        // ログイン後画面に遷移
        Spark.post("/FP02", (request, responce) -> LoginLogic.login(model, request), templateEngine);


    }
}
