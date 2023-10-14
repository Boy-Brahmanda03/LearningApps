package com.example.learningapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.learningapps.databinding.ActivitySplashScreen2Binding

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreen2Binding

    private val SPLASH_TIME_OUT:Long = 1200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreen, HomeActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}