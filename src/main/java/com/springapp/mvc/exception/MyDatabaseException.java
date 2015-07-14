package com.springapp.mvc.exception;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: transaction-demo
 * Date: 7/14/15
 * Time: 9:44 AM
 */
public class MyDatabaseException extends Exception {
    public MyDatabaseException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
