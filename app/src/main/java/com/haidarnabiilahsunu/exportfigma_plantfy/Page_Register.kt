package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.haidarnabiilahsunu.exportfigma_plantfy.databinding.ActivityPageRegisterBinding

class Page_Register : AppCompatActivity(), View.OnClickListener {
    // Deklarasi variabel
    private lateinit var binding: ActivityPageRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Inisialisasi Firebase Auth
        auth = FirebaseAuth.getInstance()
        // Set OnClickListener untuk tombol
        binding.rx5u9nzz18sd.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rx5u9nzz18sd -> {
                // Ambil email dan password dari input
                val email = binding.rbdcoy5avxur.text.toString()
                val password = binding.rkgoudy84rn.text.toString()
                createAccount(email, password)
            }
        }
    }

    private fun createAccount(email: String, password: String) {
        if (!validateForm(email, password)) {
            return
        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Akun berhasil dibuat, navigasi ke SignInActivity
                Toast.makeText(this, "Create User Success.", Toast.LENGTH_SHORT).show()
                finish() // Tutup SignUpActivity
            } else {
                // Gagal membuat akun, tampilkan pesan error
                Toast.makeText(this, "Authentication failed: ${task.exception?.message}",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Fungsi untuk memvalidasi form
    private fun validateForm(email: String, password: String): Boolean {
        var valid = true
        if (TextUtils.isEmpty(email)) {
            binding.rbdcoy5avxur.error = "Required."
            valid = false
        } else {
            binding.rbdcoy5avxur.error = null
        }
        if (TextUtils.isEmpty(password)) {
            binding.rkgoudy84rn.error = "Required."
            valid = false
        } else {
            binding.rkgoudy84rn.error = null
        }
        return valid
    }
}