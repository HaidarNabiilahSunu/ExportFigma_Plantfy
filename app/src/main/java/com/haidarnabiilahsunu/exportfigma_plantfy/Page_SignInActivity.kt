package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.haidarnabiilahsunu.exportfigma_plantfy.databinding.ActivityMainBinding
import com.haidarnabiilahsunu.exportfigma_plantfy.databinding.ActivityPageSignInBinding

class Page_SignInActivity : AppCompatActivity(), View.OnClickListener {
    // Deklarasi variabel
    private lateinit var binding: ActivityPageSignInBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageSignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Inisialisasi Firebase Auth
        auth = FirebaseAuth.getInstance()
        // Set OnClickListener untuk tombol
        binding.btnSignOut.setOnClickListener(this)
        binding.btnEmailVerify.setOnClickListener(this)
        // Move to Page Register
        val textRegister = findViewById<TextView>(R.id.wnduw123mjdjab)
        textRegister.setOnClickListener {
            val intent = Intent(this, Page_Home::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        // Periksa apakah pengguna sudah login
        val currentUser = auth.currentUser
        if (currentUser == null) {
            // Jika belum login, navigasi ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // Jika sudah login, perbarui UI dengan informasi pengguna
            updateUI(currentUser)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSignOut -> {
                // Logout pengguna
                signOut()
            }

            R.id.btnEmailVerify -> {
                // Kirim email verifikasi
                sendEmailVerification()
            }
        }
    }

    // Fungsi untuk logout
    private fun signOut() {
        auth.signOut()
        // Navigasi ke MainActivity setelah logout
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    // Fungsi untuk mengirim email verifikasi
    private fun sendEmailVerification() {
        val user = auth.currentUser
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this,
                        "Verification email sent to ${user.email}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "Failed to send verification email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    // Fungsi untuk memperbarui UI dengan informasi pengguna
    private fun updateUI(user: FirebaseUser?) {
        user?.let {
            // Tampilkan nama pengguna
            val name = it.displayName ?: "No Name"
            binding.tvName.text = name
            // Tampilkan email pengguna
            val email = it.email ?: "No Email"
            binding.tvUserId.text = email
            // Sembunyikan tombol verifikasi email jika email sudah terverifikasi
            if (it.isEmailVerified) {
                binding.btnEmailVerify.visibility = View.GONE
            } else {
                binding.btnEmailVerify.visibility = View.VISIBLE
            }
        }
    }
}