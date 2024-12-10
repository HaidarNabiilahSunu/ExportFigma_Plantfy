package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_ViewProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_view_product)

        // Move Back to Page Home
        val textHome = findViewById<ImageView>(R.id.r2a74vr9uq)
        textHome.setOnClickListener{
            val intent = Intent(this, Page_Home::class.java)
            startActivity(intent)
            finish()
        }

        // Move to Page Basket
        val textBasket = findViewById<LinearLayout>(R.id.r49ny78j13j7)
        textBasket.setOnClickListener{
            val intent = Intent(this, Page_Basket::class.java)
            startActivity(intent)
        }

        // Move to Page Payment
        val textPayment = findViewById<LinearLayout>(R.id.rsu9rhp27ioq)
        textPayment.setOnClickListener{
            val intent = Intent(this, Page_Payment::class.java)
            startActivity(intent)
        }

        // Move to Page Wishlist
        val textWishlist = findViewById<ImageView>(R.id.r2a7f34gbvr9uq)
        textWishlist.setOnClickListener{
            val intent = Intent(this, Page_Wishlist::class.java)
            startActivity(intent)
        }
    }
}