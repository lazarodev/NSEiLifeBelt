package com.gt.dev.ilifebelt.nseilifebelt.adapter;

/**
 * Created by Community on 10/11/16.
 */

public class Library {

    private String lname;
    private String lemail;
    private String lnse;

    public Library(String lname, String lemail, String lnse) {
        super();
        this.lname = lname;
        this.lemail = lemail;
        this.lnse = lnse;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLemail() {
        return lemail;
    }

    public void setLemail(String lemail) {
        this.lemail = lemail;
    }

    public String getLnse() {
        return lnse;
    }

    public void setLnse(String lnse) {
        this.lnse = lnse;
    }
}
