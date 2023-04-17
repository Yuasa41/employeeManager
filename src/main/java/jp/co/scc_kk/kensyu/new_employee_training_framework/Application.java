package jp.co.scc_kk.kensyu.new_employee_training_framework;

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

        // ログイン
        Spark.get("/", (request, responce) -> new ModelAndView(model, "login"), templateEngine);



    }
}
