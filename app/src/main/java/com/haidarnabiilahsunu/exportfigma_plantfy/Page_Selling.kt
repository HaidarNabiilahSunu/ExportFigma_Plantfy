package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.haidarnabiilahsunu.exportfigma_plantfy.adapter.MenuAdapter
import com.haidarnabiilahsunu.exportfigma_plantfy.model.Menu

class Page_Selling : AppCompatActivity() {
    // Deklarasi variabel RecyclerView, Button, Adapter, dan daftar menu
    private lateinit var rvMenu: RecyclerView
    private lateinit var btnAddMenu: Button
    private lateinit var menuAdapter: MenuAdapter
    private val menuList = mutableListOf<Menu>()

    // Inisialisasi Firebase Firestore
    private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi Firebase App
        FirebaseApp.initializeApp(this)

        // Menetapkan layout XML sebagai tampilan
        setContentView(R.layout.activity_page_selling)

        // Mendapatkan instance Firestore
        firestore = FirebaseFirestore.getInstance()

        // Menghubungkan variabel dengan komponen UI
        rvMenu = findViewById(R.id.rvMenu)
        btnAddMenu = findViewById(R.id.btnAddMenu)

        // Inisialisasi adapter dengan daftar menu dan intent ke halaman edit
        menuAdapter = MenuAdapter(menuList) { menu ->
            val intent = Intent(this, Page_EditSelling::class.java)
            intent.putExtra("menuId", menu.id)
            startActivity(intent)
        }

        // Menetapkan layout manager dan adapter untuk RecyclerView
        rvMenu.layoutManager = LinearLayoutManager(this)
        rvMenu.adapter = menuAdapter

        // Menangani klik tombol untuk menambah menu baru
        btnAddMenu.setOnClickListener {
            val intent = Intent(this, Page_InputSelling::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_MENU)
        }

        // Memuat data menu dari Firestore
        loadMenuData()

        // Move to Page Setting
        val textSetting = findViewById<ImageView>(R.id.rtsalamhn92ef)
        textSetting.setOnClickListener{
            val intent = Intent(this, Page_Setting::class.java)
            startActivity(intent)
        }

        // Move Back to Previous Page
        val textPrevious = findViewById<ImageView>(R.id.rtsalamhn2ef)
        textPrevious.setOnClickListener {
            // Mengakhiri activity saat ini dan kembali ke halaman sebelumnya
            finish()
        }
    }

    // Fungsi untuk mengambil data menu dari Firestore
    private fun loadMenuData() {
        firestore.collection("menu").get().addOnSuccessListener { documents ->
            menuList.clear() // Menghapus data lama sebelum memuat ulang
            for (document in documents) {
                val menu = document.toObject(Menu::class.java) // Konversi dokumen ke objek Menu
                menu.id = document.id // Menyimpan ID dokumen sebagai ID menu
                menuList.add(menu) // Menambahkan menu ke daftar
            }
            menuAdapter.notifyDataSetChanged() // Memberi tahu adapter bahwa data telah berubah
        }
    }

    // Menangani hasil dari aktivitas input menu baru
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_MENU && resultCode == RESULT_OK) {
            loadMenuData() // Muat ulang data jika menu berhasil ditambahkan
        }
    }

    // Menyimpan kode request untuk aktivitas tambah menu
    companion object {
        const val REQUEST_CODE_ADD_MENU = 1
    }

    // Memuat ulang data menu saat activity kembali aktif
    override fun onResume() {
        super.onResume()
        loadMenuData()
    }
}