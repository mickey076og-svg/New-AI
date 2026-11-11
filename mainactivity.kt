package com.gathee.assistant
import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val status = findViewById<TextView>(R.id.statusText)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO, Manifest.permission.CALL_PHONE, Manifest.permission.READ_CONTACTS, Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS, Manifest.permission.POST_NOTIFICATIONS), 101)
        findViewById<Button>(R.id.startBtn).setOnClickListener { startForegroundService(Intent(this, GatheeService::class.java)); status.text = "Gathee is ON - Male Voice Active" }
        findViewById<Button>(R.id.stopBtn).setOnClickListener { stopService(Intent(this, GatheeService::class.java)); status.text = "Gathee is OFF" }
        findViewById<Button>(R.id.notifBtn).setOnClickListener { startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)) }
    }
}
