package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Move to Page Register
        val textRegister = findViewById<TextView>(R.id.rlxv11dcqp6p)
        textRegister.setOnClickListener{
            val intent = Intent(this, Page_Register::class.java)
            startActivity(intent)
        }

        // Move to Page Home
        val inputUsername = findViewById<EditText>(R.id.rufwur64fpzo)
        val inputPassword = findViewById<EditText>(R.id.r3c36q7cwtad)
        val btnNext = findViewById<LinearLayout>(R.id.rmuhbd6s4n6)

        btnNext.setOnClickListener {
            val inputText1 = inputUsername.text.toString().trim()
            val inputText2 = inputPassword.text.toString().trim()

            if (inputText1.isEmpty() || inputText2.isEmpty()) {
                // Menampilkan pesan jika EditText kosong
                Toast.makeText(this, "Silakan masukkan data terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Pindah ke halaman selanjutnya jika EditText tidak kosong
                val intent = Intent(this, Page_Home::class.java)
                startActivity(intent)
            }
        }

        // Move to Page Google
        val textGoogle = findViewById<LinearLayout>(R.id.ra1epnxvafar)
        textGoogle.setOnClickListener{
            val googleIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com"))
            startActivity(googleIntent)
        }

        // Move to Page Facebook
        val textFacebook = findViewById<LinearLayout>(R.id.re8ymwc0h9e)
        textFacebook.setOnClickListener{
            val facebookIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com"))
            startActivity(facebookIntent)
        }
    }
}