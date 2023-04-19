package jp.co.scc_kk.kensyu.new_employee_training_framework.login;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

public class LogoutLogic {


    public static ModelAndView logout(Map<String, Object> model, Request request, Response responce) {
        request.session().removeAttribute("loginUser");
        request.session().removeAttribute("loginUserName");
        request.session().removeAttribute("userAuth");
        responce.redirect("/");
        return new ModelAndView(model, "login");
    }

}
