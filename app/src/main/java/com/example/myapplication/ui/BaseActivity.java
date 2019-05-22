package com.example.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.myapplication.common.exception.ExceptionHandler;

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(content());
        setUp();
    }

    protected abstract int content();


    @CallSuper
    protected void setUp()
    {}

    protected void showMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showException(Throwable throwable)
    {
        showMessage(new ExceptionHandler().getMessage(throwable));
    }

    public final void  doSomething()
    {

    }

}
