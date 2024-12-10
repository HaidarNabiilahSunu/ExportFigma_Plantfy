package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_Basket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_basket)

        // Move Back to Page Home
        val textHome = findViewById<ImageView>(R.id.rtsalamhn2ef)
        textHome.setOnClickListener{
            val intent = Intent(this, Page_Home::class.java)
            startActivity(intent)
            finish()
        }

        // Move to Page Payment
        val textPayment = findViewById<LinearLayout>(R.id.rqm2yq2j3ttd)
        textPayment.setOnClickListener{
            val intent = Intent(this, Page_Payment::class.java)
            startActivity(intent)
        }

        // Move to Page Setting
        val textSetting = findViewById<ImageView>(R.id.rtsalamhn92ef)
        textSetting.setOnClickListener{
            val intent = Intent(this, Page_Setting::class.java)
            startActivity(intent)
        }
    }
}