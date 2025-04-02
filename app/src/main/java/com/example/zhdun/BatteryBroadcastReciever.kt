package com.example.zhdun

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import android.widget.Toast

class BatteryBroadcastReciever(text: TextView) : BroadcastReceiver() {
    val timeText=text

    override fun onReceive(context: Context?, intent: Intent?) {
        timeText.text="накормите Ждуна,силы на исходе!"
    }
}