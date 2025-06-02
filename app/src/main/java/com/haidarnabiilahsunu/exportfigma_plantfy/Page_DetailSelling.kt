package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class Page_DetailSelling : AppCompatActivity() {
    // Deklarasi variabel UI dan Firebase
    private lateinit var tvNama: TextView
    private lateinit var tvHarga: TextView
    private lateinit var tvDeskripsi: TextView
    private lateinit var imgPreview: ImageView
    private lateinit var firestore: FirebaseFirestore
    private lateinit var menuId: String

    // Fungsi utama yang dijalankan saat activity dimulai
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mengatur layout activity ke activity_page_detail_selling.xml
        setContentView(R.layout.activity_page_detail_selling)

        // Inisialisasi komponen UI dari layout
        tvNama = findViewById(R.id.tvNamaMenu)
        tvHarga = findViewById(R.id.tvHargaMenu)
        tvDeskripsi = findViewById(R.id.tvDeskripsiMenu)
        imgPreview = findViewById(R.id.imgPreview)

        // Inisialisasi Firebase Firestore
        firestore = FirebaseFirestore.getInstance()
        // Mengambil menuId yang dikirim lewat Intent
        menuId = intent.getStringExtra("menuId") ?: ""

        // Ambil data produk dari Firestore
        ambilData()

        // Tombol kembali ke Page_Selling
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, Page_Selling::class.java)
            startActivity(intent)
        }

        // Tombol untuk kembali ke list produk (bisa juga digunakan untuk edit)
        val btnEdit = findViewById<Button>(R.id.btnList)
        btnEdit.setOnClickListener {
            // Menutup activity saat ini dan kembali ke halaman sebelumnya
            finish()
        }
    }

    // Fungsi untuk mengambil data produk dari Firestore berdasarkan menuId
    private fun ambilData() {
        firestore.collection("menu").document(menuId).get().addOnSuccessListener { doc ->
            // Tampilkan data ke komponen UI
            tvNama.text = doc.getString("nama")
            tvHarga.text = "Rp ${doc.getLong("harga")}"
            tvDeskripsi.text = doc.getString("deskripsi")

            // Tampilkan gambar produk menggunakan Glide
            val gambarUrl = doc.getString("gambar")
            if (!gambarUrl.isNullOrEmpty()) {
                Glide.with(this)
                    .load(gambarUrl)
                    .into(imgPreview)
            } else {
                // Jika tidak ada gambar, gunakan gambar default
                imgPreview.setImageResource(R.drawable.ic_launcher_background)
            }
        }
    }
}