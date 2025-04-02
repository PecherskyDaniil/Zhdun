package com.example.zhdun

import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var timeBroadcastReceiver:TimeBroadcastReceiver
    private lateinit var batteryLowBroadcastReciever: BatteryBroadcastReciever
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val text:TextView=findViewById(R.id.text)
        timeBroadcastReceiver = TimeBroadcastReceiver(text)
        batteryLowBroadcastReciever=BatteryBroadcastReciever(text)
        registerReceiver(
            timeBroadcastReceiver, IntentFilter(
                "android.intent.action.TIME_TICK"
            )
        )
        registerReceiver(
            batteryLowBroadcastReciever, IntentFilter(
                "android.intent.action.BATTERY_LOW"
            )
        )
        button.setOnClickListener {
            unregisterReceiver(timeBroadcastReceiver)
            Toast.makeText(
                getApplicationContext(), "Созерцание больше не фиксируется",
                Toast.LENGTH_SHORT
            ).show();
        }
    }
    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(timeBroadcastReceiver)
        Toast.makeText(
            getApplicationContext(),
            "Приёмник выключён", Toast.LENGTH_SHORT
        )
            .show();
    }
}