package com.example.administrator.download

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.administrator.download.databinding.ActivityMainBinding
import com.example.downloadhelp.DL
import com.example.downloadhelp.request.RequestOptions

class MainActivity : AppCompatActivity() {

    private lateinit var bind:ActivityMainBinding
    private lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this,R.layout.activity_main)
        model = ViewModelProviders.of(this)[MainViewModel::class.java]
        request()
    }

    private fun dispatchEvent(){
        bind.single.setOnClickListener {
            model.test(RequestOptions.SINGLE_THREAD)
        }
        bind.multi.setOnClickListener {
            model.test(RequestOptions.MULTI_THREAD)
        }
        bind.pause.setOnClickListener {
            model.pause()
        }
        bind.start.setOnClickListener {
            model.start()
        }
        model.total.observe(this, Observer {
            bind.seekBar.max = it
        })
        model.progress.observe(this, Observer {
            bind.seekBar.progress = it
        })
    }

    private fun request(){
        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),1);
        }else{
            dispatchEvent()
        }
    }



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (permissions.isNotEmpty()){
            dispatchEvent()
        }
    }
}
