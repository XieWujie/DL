package com.example.downloadhelp.request;

import android.util.Log;
import com.example.downloadhelp.DL;
import com.example.downloadhelp.cache.Fetch;
import com.example.downloadhelp.cache.Save;
import com.example.downloadhelp.converter.ReadConverter;
import com.example.downloadhelp.listener.DLCompleteListener;
import com.example.downloadhelp.listener.DLProgressListener;
import com.example.downloadhelp.task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class  ObservableRequest<ResourceType> extends SimpleRequest<ResourceType> implements DLProgressListener {

    private List<DLProgressListener> progressListeners = new ArrayList<>();


    @Override
    protected void beforeBegin() {
        super.beforeBegin();
        task.registerProgressListener(this);
    }

    @Override
    public void onProgress(int loaded, int totalLength) {
        for (int i = progressListeners.size()-1;i>-1;i--){
            progressListeners.get(i).onProgress(loaded,totalLength);
        }
    }


    @Override
    public void freshProgress() {
        task.freshProgress();
    }

    @Override
    public void registerProgressListener(DLProgressListener listener) {
        if (listener != null){
            progressListeners.add(listener);
        }
    }


}
