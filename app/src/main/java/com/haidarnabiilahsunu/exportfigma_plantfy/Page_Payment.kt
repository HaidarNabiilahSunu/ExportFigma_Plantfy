package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_Payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_payment)

        // Move Back to Page Home
        val textHome = findViewById<ImageView>(R.id.rtsalamhn2ef)
        textHome.setOnClickListener{
            val intent = Intent(this, Page_Home::class.java)
            startActivity(intent)
            finish()
        }

        // Move Back to Previous Page
        val textBasket = findViewById<LinearLayout>(R.id.r7wh6xe5u0ax7)
        textBasket.setOnClickListener{
            // Mengakhiri activity saat ini dan kembali ke halaman sebelumnya
            finish()
        }

        // Move to Page Google Maps - ( Kota Purwokerto )
        val textGoogleMaps = findViewById<LinearLayout>(R.id.rwtxes1p2t7a)
        textGoogleMaps.setOnClickListener{
            // URL untuk membuka Google Maps di browser ( Kota Purwokerto )
            val googleMapsUrl = "https://maps.app.goo.gl/4Vdzr246KTq5uwFP6"

            // Intent untuk membuka URL di browser
            val googleIntent = Intent(Intent.ACTION_VIEW, Uri.parse(googleMapsUrl))
            startActivity(googleIntent)
        }

        // Move to Page Google Maps - ( Kota Jakarta )
        val textMaps = findViewById<LinearLayout>(R.id.rwtxes1p2t87a)
        textMaps.setOnClickListener {
            // URL untuk membuka Google Maps di browser ( Kota Jakarta )
            val googleMapsUrl = "https://maps.app.goo.gl/vvj1rRaEhMoi9Utp7"

            // Intent untuk membuka URL di browser
            val googleIntent = Intent(Intent.ACTION_VIEW, Uri.parse(googleMapsUrl))
            startActivity(googleIntent)
        }

        // Move to Page Setting
        val textSetting = findViewById<ImageView>(R.id.rtsalamhn92ef)
        textSetting.setOnClickListener{
            val intent = Intent(this, Page_Setting::class.java)
            startActivity(intent)
        }
    }
}