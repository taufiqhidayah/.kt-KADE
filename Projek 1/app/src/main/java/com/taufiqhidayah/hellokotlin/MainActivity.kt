package com.taufiqhidayah.hellokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items) {
            val intent = Intent(this, SeconActivity::class.java)
            intent.putExtra("name",it.name);
            intent.putExtra("img",it.image);
            intent.putExtra("des",it.des);

            startActivity(intent)
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val des = resources.getStringArray(R.array.club_des)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],des[i],image.getResourceId(i, 0)))
        }

        //Recycle the typed array
        image.recycle()
    }
}
