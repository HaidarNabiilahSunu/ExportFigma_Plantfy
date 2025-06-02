package com.haidarnabiilahsunu.exportfigma_plantfy

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.haidarnabiilahsunu.exportfigma_plantfy.model.Menu

class Page_InputSelling : AppCompatActivity() {
    // Deklarasi variabel untuk input dan tampilan UI
    private lateinit var etNamaMenu: EditText
    private lateinit var etHargaMenu: EditText
    private lateinit var etDeskripsiMenu: EditText
    private lateinit var btnSimpanMenu: Button
    private lateinit var etGambar: EditText
    private lateinit var imgPreview: ImageView

    // Inisialisasi instance Firestore
    private val firestore = FirebaseFirestore.getInstance()

    // Fungsi yang dijalankan saat activity dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_input_selling) // Set layout XML untuk activity

        // Menghubungkan variabel dengan komponen UI di layout
        etNamaMenu = findViewById(R.id.etNamaMenu)
        etHargaMenu = findViewById(R.id.etHargaMenu)
        etDeskripsiMenu = findViewById(R.id.etDeskripsiMenu)
        btnSimpanMenu = findViewById(R.id.btnSimpanMenu)
        etGambar = findViewById(R.id.etGambar)
        imgPreview = findViewById(R.id.imgPreview)

        // Menambahkan aksi saat tombol simpan ditekan
        btnSimpanMenu.setOnClickListener {
            saveMenu() // Memanggil fungsi untuk menyimpan data menu ke Firestore
        }

        // Menambahkan listener untuk menampilkan gambar dari URL yang dimasukkan
        etGambar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val url = s.toString() // Mengambil URL dari input
                if (url.isNotEmpty()) {
                    // Jika URL tidak kosong, load gambar menggunakan Glide
                    Glide.with(this@Page_InputSelling)
                        .load(url)
                        .into(imgPreview)
                } else {
                    // Jika URL kosong, tampilkan gambar default
                    imgPreview.setImageResource(R.drawable.ic_launcher_background)
                }
            }

            // Fungsi ini tidak digunakan tapi harus di-override
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    // Fungsi untuk menyimpan data menu ke Firestore
    private fun saveMenu() {
        val nama = etNamaMenu.text.toString() // Ambil nama menu dari input
        val harga = etHargaMenu.text.toString().toDoubleOrNull()
            ?: 0.0 // Ambil harga, default 0.0 jika tidak valid
        val deskripsi = etDeskripsiMenu.text.toString() // Ambil deskripsi menu
        val gambar = etGambar.text.toString() // Ambil URL gambar

        // Buat objek Menu (asumsi ada class data Menu dengan parameter id, nama, harga, deskripsi, gambar)
        val menu = Menu(id = "", nama = nama, harga = harga, deskripsi = deskripsi, gambar = gambar)

        // Simpan objek menu ke koleksi "menu" di Firestore
        firestore.collection("menu").add(menu).addOnSuccessListener {
            // Jika berhasil, set result OK dan tutup activity
            setResult(RESULT_OK)
            finish()
        }
    }
}