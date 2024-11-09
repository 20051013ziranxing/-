package com.example.night.base;

public interface BaseView<T> {
    void setPresenter(T present);
    void sendTip(String tip);
    void success();
    void failed();
}
