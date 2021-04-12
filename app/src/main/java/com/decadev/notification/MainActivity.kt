package com.decadev.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val implementation = findViewById<Button>(R.id.btnactivity2)
        implementation.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }


        fun showNotification(title: String, message: String) {
            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                val channel = NotificationChannel("YOUR_CHANNEL_ID",
                        "YOUR_CHANNEL_NAME",
                        NotificationManager.IMPORTANCE_DEFAULT)
                channel.description = "YOUR_NOTIFICATION_CHANNEL_DESCRIPTION"
                mNotificationManager.createNotificationChannel(channel)
            }
            val mBuilder = NotificationCompat.Builder(applicationContext, "YOUR_CHANNEL_ID")
                    .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                    .setContentTitle(title) // title for notification
                    .setContentText(message)// message for notification
                    .setAutoCancel(true) // clear notification after click
            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("datain", "Active")
            val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            mBuilder.setContentIntent(pi)
            mNotificationManager.notify(0, mBuilder.build())
        }

        val notifi = findViewById<Button>(R.id.btnnotification)
        notifi.setOnClickListener{
            showNotification(" new message", "check your message")
        }
    }
}