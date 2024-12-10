package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_Product : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_product)

        // Move Back to Page Home
        val textHome = findViewById<ImageView>(R.id.r2a74vr9uq)
        textHome.setOnClickListener{
            val intent = Intent(this, Page_Home::class.java)
            startActivity(intent)
        }

        // Move to Page Profile
        val textProfile = findViewById<ImageView>(R.id.rk124c1m256)
        textProfile.setOnClickListener{
            val intent = Intent(this, Page_Profile::class.java)
            startActivity(intent)
        }

        // Move to Page Chat
        val textChat = findViewById<ImageView>(R.id.r7f34vr9e)
        textChat.setOnClickListener{
            val intent = Intent(this, Page_Chat::class.java)
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