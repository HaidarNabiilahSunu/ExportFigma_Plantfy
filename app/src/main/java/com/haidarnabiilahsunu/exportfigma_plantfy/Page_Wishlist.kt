package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_Wishlist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_wishlist)

        // Move to Page Chat
        val textChat = findViewById<ImageView>(R.id.r7f34vr9e)
        textChat.setOnClickListener{
            val intent = Intent(this, Page_Chat::class.java)
            startActivity(intent)
        }

        // Move to Page Basket
        val textBasket = findViewById<ImageView>(R.id.r2a7f34vdsr9e)
        textBasket.setOnClickListener{
            val intent = Intent(this, Page_Basket::class.java)
            startActivity(intent)
        }

        // Move to Page Basket with Product
        val textProductBasket = findViewById<LinearLayout>(R.id.rzuuwi2tnek1zb8e)
        textProductBasket.setOnClickListener{
            val intent = Intent(this, Page_Basket::class.java)
            startActivity(intent)
        }

        // Move Back to Page Home
        val textHome = findViewById<ImageView>(R.id.r2a74vr9uq)
        textHome.setOnClickListener{
            val intent = Intent(this, Page_Home::class.java)
            startActivity(intent)
        }

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
    }
}