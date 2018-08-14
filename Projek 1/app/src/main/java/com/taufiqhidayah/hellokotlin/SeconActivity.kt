package com.taufiqhidayah.hellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class SeconActivity : AppCompatActivity() {
    private var name: String = ""
    private var des: String = ""
    private var img: kotlin.Int? = null
    lateinit var nameClub: TextView
    lateinit var desClub: TextView
    lateinit var imgClub: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(16)
            imgClub = imageView()
            nameClub = textView()
            desClub = textView();
        }

        val intent = intent
        name = intent.getStringExtra("name")
        des = intent.getStringExtra("des")
        img = intent.getIntExtra("img", 0)

        nameClub.text = name
        desClub.text = des
        Glide.with(applicationContext).load(img).into(imgClub)
    }
}
