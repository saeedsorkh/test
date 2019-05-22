package com.example.myapplication.common.exception;

import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

public class ExceptionHandler {

    public String getMessage(Throwable throwable) {

        throwable.printStackTrace();

        if (throwable instanceof MyException) {
            return new StringBuilder()
                    .append(((MyException) throwable).getCode())
                    .append("/n")
                    .append(((MyException) throwable).getMessage()).toString();
//            return ((MyException)throwable).getMessage();
        } else if (throwable instanceof NullPointerException) {
            return "this is null pointer";
        } else if (throwable instanceof ConnectException) {
            return "";
        }
        else  if (throwable instanceof TimeoutException)
        {
            return"time out";
        }
        return "default exception";
    }

}
