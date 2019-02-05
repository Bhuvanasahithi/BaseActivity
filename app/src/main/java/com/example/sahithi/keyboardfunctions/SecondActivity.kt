package com.example.sahithi.keyboardfunctions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity :BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("activity","secondactivity")
    }
}
