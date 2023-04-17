package jp.co.scc_kk.kensyu.new_employee_training_framework.login;

public class TodoData {

    private int todoNo;

    private String date;

    private String event;

    private String comment;

    public TodoData(int no, String date, String event, String comment) {
        this.todoNo = no;
        this.date = date;
        this.event = event;
        this.comment = comment;
    }

    public int getTodoNo() {
        return todoNo;
    }

    public void setTodoNo(int todoNo) {
        this.todoNo = todoNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



}
