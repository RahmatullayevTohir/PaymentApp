package com.example.paymentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        initPayMant()
    }
    fun initPayMant() {
        val button = findViewById<Button>(R.id.btn_next_payment)
        button.setOnClickListener {
            openConFirm()
        }
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

    fun openConFirm() {
        val intent = Intent(this, ConfirmActivity::class.java)
        detailLauncher.launch(intent)
    }
}