package com.taufiqhidayah.learnanko

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast
import com.taufiqhidayah.learnanko.R.attr.colorAccent
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUII().setContentView(this)
    }

}

class MainActivityUII : AnkoComponent<SecondActivity> {
    @SuppressLint("ResourceType")
    override fun createView(ui: AnkoContext<SecondActivity>): View = with(ui) {
        verticalLayout{
            padding = dip(16)

            val name = editText {
                hint = "Who is your name?"
            }

            button("Say Hello"){
                backgroundColor = ContextCompat.getColor(context, colorAccent)
                textColor = Color.WHITE


                onClick { toast("Hello, ${name.text}!") }

            }.lparams(width = matchParent){
                topMargin = dip(5)
            }

            button("Show Alert"){
                backgroundColor = ContextCompat.getColor(context, colorAccent)
                textColor = Color.WHITE

                onClick {
                    alert("Happy Coding!", "Hello, ${name.text}!") {
                        yesButton { toast("Oh…") }
                        noButton {}
                    }.show()
                }
            }.lparams(width = matchParent){
                topMargin = dip(5)
            }

            button("Show Selector"){
                backgroundColor = ContextCompat.getColor(context, colorAccent)
                textColor = Color.WHITE

                onClick {
                    val club = listOf("Barcelona", "Real Madrid", "Bayern Munchen", "Liverpool")
                    selector("Hello, ${name.text}! What's football club do you love?", club) { _, i ->
                        toast("So you're love ${club[i]}, right?")
                    }
                }
            }.lparams(width = matchParent){
                topMargin = dip(5)
            }

            button("Show Snackbar"){
                backgroundColor = ContextCompat.getColor(context, colorAccent)
                textColor = Color.WHITE

                onClick {
                    snackbar(name, "Hello, ${name.text}!")

                }
            }.lparams(width = matchParent){
                topMargin = dip(5)
            }

            button("Show Progress Bar"){
                backgroundColor = ContextCompat.getColor(context, colorAccent)
                textColor = Color.WHITE

                onClick {
                    indeterminateProgressDialog("Hello, ${name.text}! Please wait...").show()
                }
            }.lparams(width = matchParent){
                topMargin = dip(5)
            }

            button("Go to Second Activity"){
                backgroundColor = ContextCompat.getColor(context, colorAccent)
                textColor = Color.WHITE

                onClick {
                    startActivity<SecondActivity>("name" to "${name.text}")
                }
            }.lparams(width = matchParent){
                topMargin = dip(5)
            }
        }
    }
}
