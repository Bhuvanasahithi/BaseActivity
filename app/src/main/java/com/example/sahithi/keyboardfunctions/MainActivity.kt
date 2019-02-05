package com.example.sahithi.keyboardfunctions

import android.annotation.TargetApi
import android.app.ActionBar
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import java.util.concurrent.TimeoutException
import android.graphics.Typeface
import android.support.v4.app.NavUtils
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.*


class MainActivity : BaseActivity() {

    var recyclerView: RecyclerView? =null
    var layoutManager: RecyclerView.LayoutManager? = null
    var recyclerviewAdapter: RecyclerviewAdapter? = null
    var searchview: SearchView? =null
    var months=ArrayList<String>()
    var btn_next: Button? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("activity","Mainactivity")
        months!!.add("January")
        months!!.add("February")
        months!!.add("March")
        months!!.add("April")
        months!!.add("May")
        months!!.add("June")
        months!!.add("July")
        months!!.add("August")
        months!!.add("September")
        months!!.add("October")
        months!!.add("November")
        months!!.add("December")
        btn_next=findViewById(R.id.next) as Button
        btn_next!!.setOnClickListener({
            var intent= Intent(this@MainActivity,Request::class.java)
            startActivity(intent)
        })

        recyclerView= findViewById(R.id.recyclerview)
        recyclerviewAdapter= RecyclerviewAdapter(this,months)
        layoutManager=LinearLayoutManager(this)
       recyclerView!!.adapter=recyclerviewAdapter
        recyclerView!!.layoutManager=layoutManager


    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId)
        {
            android.R.id.home->
            {
                recyclerviewAdapter!!.notifyDataSetChanged()
                NavUtils.navigateUpFromSameTask(this)
            }

        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        val searchManager=getSystemService(Context.SEARCH_SERVICE) as SearchManager
         searchview=(menu!!.findItem(R.id.search).actionView) as SearchView
        searchview!!.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchview!!.isActivated=true
        searchview!!.onActionViewExpanded()
        searchview!!.setIconified(false)

        searchview!!.queryHint="Search"
        searchview!!.setOnQueryTextListener(object:SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
              var filteredlist=recyclerviewAdapter!!.filter.filter(newText);

                return false
            }

        })

    return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        searchview!!.onActionViewCollapsed()
    }
}




