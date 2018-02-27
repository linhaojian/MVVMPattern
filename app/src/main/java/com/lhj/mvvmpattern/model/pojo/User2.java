package com.lhj.mvvmpattern.model.pojo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/2/27.
 */

public class User2 {
    private String username;
    private String nickname;
    private int age;
    private int userface;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserface() {
        return userface;
    }

    public void setUserface(int userface) {
        this.userface = userface;
    }

}
