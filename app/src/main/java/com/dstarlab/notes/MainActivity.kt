package com.dstarlab.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Notes)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}