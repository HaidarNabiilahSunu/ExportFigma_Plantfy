package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_register)

        // Move to Page Home
        val inputEmail = findViewById<EditText>(R.id.rbdcoy5avxur)
        val inputPassword = findViewById<EditText>(R.id.rkgoudy84rn)
        val btnNext = findViewById<LinearLayout>(R.id.rx5u9nzz18sd)

        btnNext.setOnClickListener {
            val inputText1 = inputEmail.text.toString().trim()
            val inputText2 = inputPassword.text.toString().trim()

            if (inputText1.isEmpty() || inputText2.isEmpty()) {
                // Menampilkan pesan jika EditText kosong
                Toast.makeText(this, "Silakan masukan data terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Pindah ke halaman selanjutnya jika EditText tidak kosong
                val intent = Intent(this, Page_Home::class.java)
                startActivity(intent)
            }
        }
    }
}