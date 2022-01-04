package com.example.paymentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    var backPraessedTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    override fun onBackPressed() {
        if (backPraessedTime +2000>System.currentTimeMillis()){
            super.onBackPressed()
            finish()
        }
        else{
            Toast.makeText(this,"Press back again to leave the app", Toast.LENGTH_LONG).show()
        }
        backPraessedTime = System.currentTimeMillis()
    }

    var detailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){

    }

    fun initViews() {
        val button = findViewById<Button>(R.id.btn_next_main)
        button.setOnClickListener { openPayMantActivity() }
    }

    fun openPayMantActivity() {
        val intent = Intent(this, PaymentActivity::class.java)
        detailLauncher.launch(intent)
    }
}