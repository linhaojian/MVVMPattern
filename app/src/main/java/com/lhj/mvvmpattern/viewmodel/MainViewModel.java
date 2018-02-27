package com.lhj.mvvmpattern.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.lhj.mvvmpattern.model.dao.User2Dao;
import com.lhj.mvvmpattern.model.pojo.User2;

import java.io.BufferedReader;

/**
 *  ViewModel : 只处理业务逻辑与操作数据，不涉及UI相关的更新
 */
public class MainViewModel{
    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> nickname = new ObservableField<>();
    public ObservableField<Integer> age = new ObservableField<>();
    public ObservableField<Integer> userface = new ObservableField<>();
    private User2Dao user2Dao = new User2Dao();

    public MainViewModel(){

    }

    /**
     * 自定义绑定属性，在xml里通过app:新属性 的方式进行使用
     * @param imageView
     * @param userfaceResId
     */
    @BindingAdapter({"userface"})
    public static void getImage(ImageView imageView, int userfaceResId){
        imageView.setImageResource(userfaceResId);
    }


    /**
     * 事件处理
     * @param v
     */
    public void onClick1(View v) {
        user2Dao.getUser(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                User2 user2 = (User2) msg.obj;
                //set 会自动UI更新数据，并且在主线程。
                username.set(user2.getUsername());
                nickname.set(user2.getNickname());
                age.set(user2.getAge());
                userface.set(user2.getUserface());
                return true;
            }
        });
    }
}
