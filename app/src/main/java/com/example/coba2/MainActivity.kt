package com.example.coba2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.coba2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val registeredFullname = intent.getStringExtra("key_fullname")
        val registeredUsername = intent.getStringExtra("key_username")
        val registeredPassword = intent.getStringExtra("key_password")

        binding.editUsername.setText(registeredUsername)

        binding.btnLogin.setOnClickListener {
            val inputUsername = binding.editUsername.text.toString()
            val inputPassword = binding.editPassword.text.toString()

            if (inputUsername.isBlank() || inputPassword.isBlank()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (inputUsername == registeredUsername && inputPassword == registeredPassword) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("key_fullname", registeredFullname)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnGoToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
