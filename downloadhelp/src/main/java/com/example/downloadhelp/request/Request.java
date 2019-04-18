package com.example.downloadhelp.request;

import com.example.downloadhelp.Next;
import com.example.downloadhelp.Obtain;
import com.example.downloadhelp.listener.*;

import java.util.concurrent.Future;

public interface Request<T> extends Next<Request<T>>
{

    void begin();

    void recycle();

    void cancel();


    void pause();

    void start();

    boolean isRecycler();

    boolean isRunning();

    boolean isPause();

    boolean isCancel();

    boolean isReady();

    Future<T> get();


    void registerCompleteListener(DLCompleteListener<T> completeListener);

    void registerFailListener(DLFailListener failListener);

    void registerStateListener(StateListener listener);

    void registerProgressListener(DLProgressListener listener);

    void freshProgress();

}
