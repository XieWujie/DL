package com.example.downloadhelp.cache;

import com.example.downloadhelp.listener.OnReadyListener;

public class FetchSupport implements Fetch {

    @Override
    public <T> boolean fetch(String url, Class<T> c, OnReadyListener<T> listener) {
        return false;
    }
}
