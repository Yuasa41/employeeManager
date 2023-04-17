package jp.co.scc_kk.kensyu.new_employee_training_framework.login;

import spark.ModelAndView;
import spark.Request;

import java.util.ArrayList;
import java.util.Map;

public class LoginLogic {



    public static ModelAndView login(Map<String, Object> model, Request request) {
        final String USER_ID = request.queryParams("userId");
        final String PASSWORD = request.queryParams("password");

        ArrayList<TodoData> todoList = new ArrayList<>();

        todoList.add(new TodoData(1, "2023/4/13", "hogehoge", "なし"));
        todoList.add(new TodoData(2, "2023/4/13", "hogehoge", "なし"));
        todoList.add(new TodoData(3, "2023/4/13", "hogehoge", "なし"));



        model.put("userId", USER_ID);
        model.put("password", PASSWORD);
        model.put("todoList", todoList);
        return new ModelAndView(model, "confirm");
    }


}
