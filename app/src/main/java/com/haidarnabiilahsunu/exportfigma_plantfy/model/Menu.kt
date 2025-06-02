package com.haidarnabiilahsunu.exportfigma_plantfy.model

// Data class Menu untuk merepresentasikan data menu
data class Menu(
    var id: String = "",          // ID dokumen (dapat diubah)
    val nama: String = "",        // Nama menu
    val harga: Double = 1000.00,  // Harga menu
    val deskripsi: String = "",   // Deskripsi menu
    val gambar: String = ""       // URL gambar menu
)