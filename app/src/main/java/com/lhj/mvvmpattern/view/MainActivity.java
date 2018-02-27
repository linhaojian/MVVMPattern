package com.lhj.mvvmpattern.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lhj.mvvmpattern.R;
import com.lhj.mvvmpattern.databinding.ActivityMainBinding;
import com.lhj.mvvmpattern.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setMainViewModel(new MainViewModel());
    }
}
