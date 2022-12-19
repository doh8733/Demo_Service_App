package com.example.demo_service_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private val edtData: EditText by lazy { findViewById<EditText>(R.id.edtData) }
    private val btnStartService: Button by lazy { findViewById<Button>(R.id.btnStartService) }
    private val btnStopService: Button by lazy { findViewById<Button>(R.id.btnStopService) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        startService()
//        stopService()
//        bindService()
        btnStartService.setOnClickListener {
            onStartService()
        }
        btnStopService.setOnClickListener {
            onStopService()
        }
    }

    private fun onStopService() {
        val intent = Intent(this,MyService::class.java)
        stopService(intent)
    }

    private fun onStartService() {
        val intent = Intent(this,MyService::class.java)
        intent.putExtra("DATA_INTENT",edtData.text.toString().trim())
        startService(intent)
    }
}