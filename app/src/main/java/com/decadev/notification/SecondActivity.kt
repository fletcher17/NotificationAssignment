package com.decadev.notification

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_main.*

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main)

                //   notify_text.text = "Active"
        updateText()
    }

    private fun updateText() {
        var active = intent.getStringExtra("datain")
        if (active != null) {
            notify_text.text = active
        }
    }
}