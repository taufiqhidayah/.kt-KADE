package com.taufiqhidayah.learnanko

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

    }
}
class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout{

            imageView(R.drawable.ic_launcher_background).
                    lparams(width= matchParent) {
                        padding = dip(20)
                        margin = dip(15)
                    }

            val name = editText(){
                hint = "What's your name?"
            }

          button("Say Hello"){
          }
        }
    }
}