package com.example.administrator.download

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.downloadhelp.DL
import com.example.downloadhelp.DLManager
import com.example.downloadhelp.request.Request
import java.io.File

class MainViewModel : ViewModel() {

    val s = "https://dl.softmgr.qq.com/original/im/QQ9.1.0.24712-0412.exe"
    val isPause = MutableLiveData<Boolean>()
    val total = MutableLiveData<Int>()
    val progress = MutableLiveData<Int>();
    private var request: Request<File>? = null;

     fun test(strategy: Int, manager: DLManager) {
        request = manager.load(s).threadMode(strategy).segment(5).submit()
        request?.registerProgressListener { loaded, totalLength ->
            progress.postValue(loaded)
            if (total.value != totalLength) {
                total.postValue(totalLength)
            }
        }
        request?.registerFailListener {
            it.printStackTrace()
        }
    }

    fun pause() {
        request?.pause()
    }

    fun start() {
        request?.start()
    }
}