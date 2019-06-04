package app.h2omvvm.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Cozycodes on 5/26/2017.
 */

public class MyOrderResp {

    public String getRes_msg() {
        return res_msg;
    }

    public void setRes_msg(String res_msg) {
        this.res_msg = res_msg;
    }

    public String getRes_code() {
        return res_code;
    }

    public void setRes_code(String res_code) {
        this.res_code = res_code;
    }

    @SerializedName("res_msg")
    private String res_msg;

    @SerializedName("res_code")
    private String res_code;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_nicename() {
        return user_nicename;
    }

    public void setUser_nicename(String user_nicename) {
        this.user_nicename = user_nicename;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_registered() {
        return user_registered;
    }

    public void setUser_registered(String user_registered) {
        this.user_registered = user_registered;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getPhone_one() {
        return phone_one;
    }

    public void setPhone_one(String phone_one) {
        this.phone_one = phone_one;
    }

    @SerializedName("ID")
    private String ID;

    @SerializedName("user_login")
    private String user_login;

    @SerializedName("user_nicename")
    private String user_nicename;

    @SerializedName("user_email")
    private String user_email;

    @SerializedName("user_registered")
    private String user_registered;

    @SerializedName("display_name")
    private String display_name;

    @SerializedName("home_address")
    private String home_address;

    @SerializedName("phone_one")
    private String phone_one;

    @SerializedName("details")
    @Expose
    private ArrayList<MyOrderResp> details = new ArrayList<>();

    public ArrayList<MyOrderResp> getOrder() {
        return details;
    }
}
