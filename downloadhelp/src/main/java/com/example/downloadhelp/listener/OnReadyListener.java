package com.example.downloadhelp.listener;

public interface OnReadyListener<T> extends DLListener {
    void onReady(T t);
}
