package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_Chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_chat)

        // Move Back to Previous Page
        val textPrevious = findViewById<ImageView>(R.id.rtsalamhn2ef)
        textPrevious.setOnClickListener{
            // Mengakhiri activity saat ini dan kembali ke halaman sebelumnya
            finish()
        }

        // Move Back to Page Home
        val textHome = findViewById<ImageView>(R.id.r2a74vr9uq)
        textHome.setOnClickListener{
            val intent = Intent(this, Page_Home::class.java)
            startActivity(intent)
        }

        // Move to Page Setting
        val textSetting = findViewById<ImageView>(R.id.rtsalamhn92ef)
        textSetting.setOnClickListener{
            val intent = Intent(this, Page_Setting::class.java)
            startActivity(intent)
        }

        // Move to Page Basket
        val textPayment = findViewById<ImageView>(R.id.r2a7f34vdsr9e)
        textPayment.setOnClickListener{
            val intent = Intent(this, Page_Basket::class.java)
            startActivity(intent)
        }
    }
}