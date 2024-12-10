package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_profile)

        // Move Back to Previous Page
        val textPrevious = findViewById<ImageView>(R.id.rtsalamhn2ef)
        textPrevious.setOnClickListener{
            // Mengakhiri activity saat ini dan kembali ke halaman sebelumnya
            finish()
        }

        // Move to Page Setting
        val textSetting = findViewById<ImageView>(R.id.rtsalamhn92ef)
        textSetting.setOnClickListener{
            val intent = Intent(this, Page_Setting::class.java)
            startActivity(intent)
        }

        // Move to Page History
        val textHistory = findViewById<TextView>(R.id.rcm5zg01ujs7)
        textHistory.setOnClickListener{
            val intent = Intent(this, Page_History::class.java)
            startActivity(intent)
        }
    }
}