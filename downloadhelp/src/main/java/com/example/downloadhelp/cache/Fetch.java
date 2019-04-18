package com.example.downloadhelp.cache;

import com.example.downloadhelp.listener.OnReadyListener;

public interface Fetch {

     <T>boolean fetch(String url, Class<T> c, OnReadyListener<T> listener);

}
