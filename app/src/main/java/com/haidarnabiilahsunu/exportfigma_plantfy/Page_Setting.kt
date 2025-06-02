package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_setting)

        // Move to Page Selling
        val textSelling = findViewById<TextView>(R.id.r5u6oq1i1w06)
        textSelling.setOnClickListener{
            val intent = Intent(this, Page_Selling::class.java)
            startActivity(intent)
        }

        // Move Back to Previous Page
        val textPrevious = findViewById<ImageView>(R.id.rtsalamhn2ef)
        textPrevious.setOnClickListener {
            // Mengakhiri activity saat ini dan kembali ke halaman sebelumnya
            finish()
        }

        // Move Back to First Page
        val textFisrt = findViewById<TextView>(R.id.rm5zfg01eujs7)
        textFisrt.setOnClickListener {
            // Berpindah ke halaman pertama menggunakan Intent
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish() // Mengakhiri activity saat ini
        }

    }
}