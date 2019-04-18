package com.example.downloadhelp.listener;

public interface DLProgressListener extends DLListener{

    void onProgress(int loaded,int totalLength);

}
