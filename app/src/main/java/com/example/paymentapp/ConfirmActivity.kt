package com.example.paymentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        initConFirm()
    }

    fun initConFirm() {
        val btn_ConFirm = findViewById<Button>(R.id.btn_next_confirm)
        btn_ConFirm.setOnClickListener { openStatns() }
    }

    var detailLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode== RESULT_OK){
            backToFinish()
        }
    }

    private fun backToFinish(){
        val returnIntent = Intent()
        setResult(RESULT_OK, returnIntent)
        finish()
    }

    fun openStatns() {
        val intent = Intent(this, StatusActivity::class.java)
        startActivity(intent)
    }
}