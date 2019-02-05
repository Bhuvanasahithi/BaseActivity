package com.example.sahithi.keyboardfunctions

import android.bluetooth.BluetoothAssignedNumbers
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class Request : BaseActivity() {

    var btn_next: Button? = null
    var btn_array: Button? = null
    var btn_object: Button? = null
    var tv_data: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)
        Log.e("activity","requestactivity")
        textView!!.setText("Request")
        btn_next=findViewById(R.id.btn_string)
        btn_array=findViewById(R.id.btn_array)
        btn_object=findViewById(R.id.btn_object)
        tv_data=findViewById(R.id.tv_data)
        btn_next!!.setOnClickListener({
            var intent=Intent(this@Request,SecondActivity::class.java)
            startActivity(intent)
        })
        btn_array!!.setOnClickListener({

        })
        btn_object!!.setOnClickListener({

        })
    }
}


