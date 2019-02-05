package com.example.sahithi.keyboardfunctions

import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

open class BaseActivity : AppCompatActivity() {
    open var textView: TextView? = null
    var avctivity:Activity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        Log.e("activity","baseactivity")
        textView=TextView(this)
        textView!!.text = resources.getString(R.string.app_name)
        textView!!.textSize = 20f
        textView!!.setTypeface(null, Typeface.BOLD)
        textView!!.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        textView!!.gravity = Gravity.CENTER
        textView!!.setTextColor(Color.WHITE)
        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.customView = textView
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }
}
