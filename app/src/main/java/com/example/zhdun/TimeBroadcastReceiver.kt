package com.example.zhdun

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import android.widget.Toast
import java.text.Format
import java.text.SimpleDateFormat
import java.util.Date

class TimeBroadcastReceiver(text: TextView) : BroadcastReceiver() {
    val timeText=text
    var countMinutes=0;
    override fun onReceive(context: Context?, intent: Intent?) {
        val msgStr = StringBuilder("Текущее время: ")
        val formatter: Format = SimpleDateFormat("hh:mm:ss a")
        msgStr.append(formatter.format(Date()))
        countMinutes+=1
        timeText.text="Вы созерцаете уже " + countMinutes.toString() +" минут"
        //Toast.makeText(context, msgStr, Toast.LENGTH_SHORT).show()
    }
}