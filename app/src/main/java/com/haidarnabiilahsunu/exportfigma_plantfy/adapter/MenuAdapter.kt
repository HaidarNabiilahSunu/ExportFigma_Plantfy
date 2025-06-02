package com.haidarnabiilahsunu.exportfigma_plantfy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.haidarnabiilahsunu.exportfigma_plantfy.R
import com.haidarnabiilahsunu.exportfigma_plantfy.model.Menu

class MenuAdapter(
    // Adapter untuk menampilkan daftar menu dalam RecyclerView
    private val menuList: List<Menu>, // Daftar data menu
    private val onItemClick: (Menu) -> Unit // Fungsi callback saat item diklik
    ) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    // Membuat ViewHolder baru saat diperlukan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return MenuViewHolder(view)
    }

    // Mengisi data ke ViewHolder sesuai posisi
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = menuList[position]
        holder.tvNamaMenu.text = menu.nama // Set nama menu
        holder.tvHarga.text = "Rp ${menu.harga}" // Set harga menu
        holder.tvDeskripsi.text = menu.deskripsi // Set deskripsi menu
        holder.itemView.setOnClickListener { onItemClick(menu) } // Event klik item

        // Tampilkan gambar menggunakan Glide
        Glide.with(holder.itemView.context)
            .load(menu.gambar)
            .placeholder(R.drawable.ic_launcher_background) // Gambar saat loading
            .error(R.drawable.ic_launcher_background) // Gambar jika gagal load
            .into(holder.imgMenu)
    }

    // Mengembalikan jumlah item dalam list
    override fun getItemCount(): Int {
        return menuList.size
    }

    // ViewHolder untuk menyimpan referensi view item
    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNamaMenu: TextView = itemView.findViewById(R.id.textProductName)
        val tvHarga: TextView = itemView.findViewById(R.id.textProductPrice)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.textProductDesc)
        val imgMenu: ImageView = itemView.findViewById(R.id.imageProduct)
    }
}
