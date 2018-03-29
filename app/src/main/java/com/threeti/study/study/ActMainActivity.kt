package com.threeti.study.study

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.tbruyelle.rxpermissions2.RxPermissions
import com.threeti.study.study.app.GlideApp
import kotlinx.android.synthetic.main.act_main.*


class ActMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()

        sample_text.setOnClickListener {
            requestPermissionCom()
            GlideApp.with(this)
                    .load("")
                    .miniThumb()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .fitCenter()
                    .into(iv_glide_pic);
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    //申请权限
    fun requestPermission(){
        stringFromJNI()
        val rxPermissions = RxPermissions(this) // where this is an Activity instance
        rxPermissions
                .requestEach(Manifest.permission.CAMERA)
                .subscribe { // will emit 2 Permission objects
                    permission ->
                    if (permission.granted) {
                        // `permission.name` is granted !
                        Toast.makeText(this , "获取权限" ,Toast.LENGTH_LONG)
                                .show()
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // Denied permission without ask never again
                        Toast.makeText(this , "再次权限权限" ,Toast.LENGTH_LONG)
                                .show()
                    } else {
                        // Denied permission with ask never again
                        // Need to go to the settings
                        Toast.makeText(this , "设置界面，打开权限" ,Toast.LENGTH_LONG)
                                .show()
                    }
                }
    }

    fun requestPermissionCom(){
        val rxPermissions = RxPermissions(this) // where this is an Activity instance
        rxPermissions.requestEachCombined(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe{
                    if (it.granted) {
                        // All permissions are granted !
                        Toast.makeText(this , "获取所有权限" ,Toast.LENGTH_LONG)
                                .show()
                    } else if (it.shouldShowRequestPermissionRationale){
                    // At least one denied permission without ask never again
                        Toast.makeText(this , "至少一个权限没有获取" ,Toast.LENGTH_LONG)
                                .show()
                    } else {
                        // At least one denied permission with ask never again
                        // Need to go to the settings
                        Toast.makeText(this , "至少一个权限没有获取，选择不再提示" ,Toast.LENGTH_LONG)
                                .show()
                    }
         }

    }
    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

}
