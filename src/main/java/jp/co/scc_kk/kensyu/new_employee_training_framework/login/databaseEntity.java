package jp.co.scc_kk.kensyu.new_employee_training_framework.login;

public class databaseEntity {
    private int id;
    private String pass;
    private int authlevel;
    private int slavenum;
    private String slavename;
    private int slavedept;

    public void setId(int id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAuthLevel(int authlevel) {
        this.authlevel = authlevel;
    }

    public void setSlaveNum(int slavenum) {
        this.slavenum = slavenum;
    }

    public void setSlaveName(String slavename) {
        this.slavename = slavename;
    }

    public void setSlaveDept(int slavedept) {
        this.slavedept = slavedept;
    }


    public int getId() {
        return this.id;
    }

    public String getPass() {
        return this.pass;
    }

    public int getAuthLevel() {
        return this.authlevel;
    }

    public int getSlaveNum() {
        return this.slavenum;
    }

    public String getSlaveName() {
        return this.slavename;
    }

    public int getSlavedept() {
        return this.slavedept;
    }
}
