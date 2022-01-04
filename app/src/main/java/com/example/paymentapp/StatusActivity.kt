package com.example.paymentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)
        initViews()
    }

    fun initViews() {
        val yesButton = findViewById<Button>(R.id.btn_exit_yes)
        val noButton = findViewById<Button>(R.id.btn_exit_no)
        yesButton.setOnClickListener {
            backToFinish()
        }
        noButton.setOnClickListener {
            finish()
        }
    }

    private fun backToFinish() {
        val returnIntent = Intent()
        setResult(RESULT_OK, returnIntent)
        finish()
    }
}