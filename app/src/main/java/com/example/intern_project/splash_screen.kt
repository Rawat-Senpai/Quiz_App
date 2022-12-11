package com.example.intern_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_splash_screen.*

class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        splashButton.setOnClickListener{
            startQuizActivity()
        }

        splashStart.setOnClickListener{
            startQuizActivity()
        }

    }

    private fun startQuizActivity() {
        var intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}