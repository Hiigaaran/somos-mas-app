package com.example.somosmasapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.somosmasapp.R
import android.content.Intent
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast

@Suppress("DEPRECATION")
class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val text = "Timer has finished!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            //finish()
            toast.show()
        }, 5000) // 5000 is the delayed time in milliseconds.



    }
    }









