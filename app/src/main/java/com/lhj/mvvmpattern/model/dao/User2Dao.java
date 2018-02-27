package com.lhj.mvvmpattern.model.dao;

import android.os.Handler;
import android.os.Message;

import com.lhj.mvvmpattern.R;
import com.lhj.mvvmpattern.model.pojo.User2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Administrator on 2018/2/27.
 */

public class User2Dao {

    public void getUser(final Handler.Callback callback){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final User2 user = new User2();
                    user.setAge(34);
                    user.setUsername("haojian");
                    user.setUserface(R.mipmap.ic_launcher);
                    user.setNickname("lin");
                    Thread.sleep(1000);
                    Message message = Message.obtain();
                    message.obj = user;
                    callback.handleMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
