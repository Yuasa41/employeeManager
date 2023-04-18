package jp.co.scc_kk.kensyu.new_employee_training_framework.main;

import java.util.ArrayList;

/**
 * 社員情報のリストを管理します。
 * 
 * @author atsutaka-yuasa
 *
 */

public class EmployeeEntity {

    // 社員リスト
    ArrayList<EmployeeData> employeeList = new ArrayList<EmployeeData>();


    public void appendList(EmployeeData employeeData) {
        this.employeeList.add(employeeData);
    }



}
