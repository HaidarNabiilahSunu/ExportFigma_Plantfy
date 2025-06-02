package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class Page_EditSelling : AppCompatActivity() {
    // Deklarasi variabel komponen UI dan Firebase
    private lateinit var etNama: EditText
    private lateinit var etHarga: EditText
    private lateinit var etDeskripsi: EditText
    private lateinit var etGambar: EditText
    private lateinit var btnUbah: Button
    private lateinit var btnHapus: Button
    private lateinit var firestore: FirebaseFirestore
    private lateinit var menuId: String
    private lateinit var imgPreview: ImageView
    private lateinit var btnDetail: Button

    // Fungsi utama yang dijalankan saat activity dimulai
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_edit_selling) // Menetapkan layout XML untuk activity

        // Menghubungkan variabel dengan komponen UI pada layout
        etNama = findViewById(R.id.etNamaMenu)
        etHarga = findViewById(R.id.etHargaMenu)
        etDeskripsi = findViewById(R.id.etDeskripsiMenu)
        btnUbah = findViewById(R.id.btnUbah)
        btnHapus = findViewById(R.id.btnHapus)
        etGambar = findViewById(R.id.etGambar)
        imgPreview = findViewById(R.id.imgPreview)
        btnDetail = findViewById(R.id.btnDetail)

        // Inisialisasi Firestore
        firestore = FirebaseFirestore.getInstance()

        // Mendapatkan ID menu yang dikirim dari Intent sebelumnya
        menuId = intent.getStringExtra("menuId") ?: ""

        // Memanggil fungsi untuk mengambil data menu berdasarkan ID
        ambilData()

        // Aksi ketika tombol "Ubah" ditekan
        btnUbah.setOnClickListener {
            // Membuat data yang akan diupdate dalam bentuk Map
            val update = mapOf(
                "nama" to etNama.text.toString(),
                "harga" to etHarga.text.toString().toInt(),
                "deskripsi" to etDeskripsi.text.toString(),
                "gambar" to etGambar.text.toString()
            )

            // Mengupdate dokumen menu di Firestore
            firestore.collection("menu").document(menuId).update(update).addOnSuccessListener {
                Toast.makeText(this, "Menu diubah", Toast.LENGTH_SHORT).show()
                finish() // Menutup activity setelah berhasil
            }
        }

        // Aksi ketika tombol "Detail" ditekan
        btnDetail.setOnClickListener {
            val intent = Intent(this, Page_DetailSelling::class.java)
            intent.putExtra("menuId", menuId)
            startActivity(intent)
        }

        // Aksi ketika tombol "Hapus" ditekan
        btnHapus.setOnClickListener {
            // Menghapus dokumen menu dari Firestore
            firestore.collection("menu").document(menuId).delete().addOnSuccessListener {
                Toast.makeText(this, "Menu dihapus", Toast.LENGTH_SHORT).show()
                finish() // Menutup activity setelah berhasil
            }
        }

        // Listener untuk perubahan pada input URL gambar
        etGambar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val url = s.toString()
                if (url.isNotEmpty()) {
                    // Jika URL tidak kosong, tampilkan gambar menggunakan Glide
                    Glide.with(this@Page_EditSelling)
                        .load(url)
                        .into(imgPreview)
                } else {
                    // Jika kosong, tampilkan gambar default
                    imgPreview.setImageResource(R.drawable.ic_launcher_background)
                }
            }

            // Fungsi-fungsi wajib dari TextWatcher meskipun tidak digunakan
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    // Fungsi untuk mengambil data menu berdasarkan ID dari Firestore
    private fun ambilData() {
        firestore.collection("menu").document(menuId).get().addOnSuccessListener { doc ->
            // Menampilkan data yang diambil ke input field
            etNama.setText(doc.getString("nama"))
            etHarga.setText(doc.getLong("harga")?.toString() ?: "")
            etDeskripsi.setText(doc.getString("deskripsi"))
            etGambar.setText(doc.getString("gambar"))
        }
    }
}