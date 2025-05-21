package com.example.coba2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.coba2.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegister.setOnClickListener {
            val fullname = binding.editFullname.text.toString()
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()
            val confirm = binding.editConfirm.text.toString()

            if (username.isNotBlank() && password.isNotBlank() && password == confirm) {
                Toast.makeText(this, "Register berhasil, silakan login", Toast.LENGTH_SHORT).show()

                // Kirim data ke MainActivity (login)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("key_fullname", fullname)
                intent.putExtra("key_username", username)
                intent.putExtra("key_password", password)
                startActivity(intent)
                finish()

            } else if (password != confirm) {
                Toast.makeText(this, "Password tidak sama dengan konfirmasi!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Data tidak boleh ada yang kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
