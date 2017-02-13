package io.muic.ooc.assigment4;

import javax.servlet.http.Cookie;

/**
 * Created by arparnuch on 2/13/2017 AD.
 */
public class User {
    private String username;
    private String password;
    private Cookie cookie;

    public User(String username, String password, Cookie cookie){
        this.username = username;
        this.password = password;
        this.cookie = cookie;
    }


    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
