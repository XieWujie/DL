package com.example.downloadhelp.listener;

public interface DLCompleteListener<Source> extends DLListener{

    void onComplete(String url,Source source);
}
