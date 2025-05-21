package com.example.coba2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coba2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil nama dari Intent
        val fullName = intent.getStringExtra("key_fullname") ?: "User"
        binding.textWelcome.text = "Welcome, $fullName"
    }
}
