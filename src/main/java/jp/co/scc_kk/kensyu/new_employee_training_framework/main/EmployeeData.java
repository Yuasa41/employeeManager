package jp.co.scc_kk.kensyu.new_employee_training_framework.main;

public class EmployeeData {

    int employeeId;

    String employeeName;

    int departmentId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void info() {
        System.out.println(employeeId);
        System.out.println(employeeName);
        System.out.println(departmentId);
    }



}
