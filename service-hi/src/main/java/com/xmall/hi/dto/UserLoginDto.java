package com.xmall.hi.dto;

import com.xmall.hi.Entity.JWT;
import com.xmall.hi.Entity.User;

public class UserLoginDto {
    private JWT jwt;
    private User user;

    public JWT getJwt() {
        return jwt;
    }

    public void setJwt(JWT jwt) {
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "jwt=" + jwt +
                ", user=" + user +
                '}';
    }
}
