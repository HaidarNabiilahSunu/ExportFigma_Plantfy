package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page_Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_home)

        // Move to Page Search
        val textSearch = findViewById<LinearLayout>(R.id.romykmr6hug7)
        textSearch.setOnClickListener{
            val intent = Intent(this, Page_Search::class.java)
            startActivity(intent)
        }

        // Move to Page View Product
        val textViewProduct = findViewById<LinearLayout>(R.id.ry7ayuimx7wg)
        textViewProduct.setOnClickListener{
            val intent = Intent(this, Page_ViewProduct::class.java)
            startActivity(intent)
        }

        // Move to Page Profile
        val textProfile = findViewById<ImageView>(R.id.rswul22ofoog)
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
        val textBasket = findViewById<ImageView>(R.id.r2a7f34vdsr9e)
        textBasket.setOnClickListener{
            val intent = Intent(this, Page_Basket::class.java)
            startActivity(intent)
        }

        // Move to Page Wishlist
        val textWishlist = findViewById<ImageView>(R.id.r2a7f34gbvr9uq)
        textWishlist.setOnClickListener{
            val intent = Intent(this, Page_Wishlist::class.java)
            startActivity(intent)
        }

        // Move to Page Loyalitas
        val textLoyalitas = findViewById<LinearLayout>(R.id.r3ulg7lgv40j)
        textLoyalitas.setOnClickListener{
            val intent = Intent(this, Page_Loyalitas::class.java)
            startActivity(intent)
        }
    }
}