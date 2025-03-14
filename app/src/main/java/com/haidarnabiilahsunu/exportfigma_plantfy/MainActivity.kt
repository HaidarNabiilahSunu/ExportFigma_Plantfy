package com.haidarnabiilahsunu.exportfigma_plantfy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
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
import com.google.firebase.auth.GoogleAuthProvider
import com.haidarnabiilahsunu.exportfigma_plantfy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Deklarasi variabel
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Inisialisasi Firebase Auth
        auth = FirebaseAuth.getInstance()
        // Set OnClickListener untuk tombol
        binding.rmuhbd6s4n6.setOnClickListener(this) // Move to Page Home
        binding.ra1epnxvafar.setOnClickListener(this) // Move to Page Google
        binding.re8ymwc0h9e.setOnClickListener(this) // Move to Page Facebook
        binding.rlxv11dcqp6p.setOnClickListener(this) // Move to Page Register
        // Inisialisasi Google Sign-In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)) // Ganti dengan client ID Anda
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        // Move to Page Facebook
        val textFacebook = findViewById<LinearLayout>(R.id.re8ymwc0h9e)
        textFacebook.setOnClickListener{
            val facebookIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com"))
            startActivity(facebookIntent)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rmuhbd6s4n6 -> {
                // Login dengan Email/Password
                val email = binding.rufwur64fpzo.text.toString()
                val password = binding.r3c36q7cwtad.text.toString()
                signIn(email, password)
            }
            R.id.rlxv11dcqp6p -> {
                // Navigasi ke halaman Sign Up
                val intent = Intent(this, Page_Register::class.java)
                startActivity(intent)
            }
            R.id.ra1epnxvafar -> {
                // Login dengan Google
                signInWithGoogle()
            }
        }
    }

    private fun signIn(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter your Email and Password first!",
                Toast.LENGTH_SHORT).show()
            return
        }
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login berhasil, navigasi ke Page_SignInActivity
                    val intent = Intent(this, Page_SignInActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Login gagal, tampilkan pesan error
                    Toast.makeText(this, "Authentication failed: ${task.exception?.message}",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun signInWithGoogle() {
        // Sign out first to force account selection
        googleSignInClient.signOut().addOnCompleteListener {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign-In berhasil, autentikasi dengan Firebase
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign-In gagal, tampilkan pesan error
                Log.w("SignInActivity", "Google sign in failed", e)
                Toast.makeText(this, "Google sign in failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login berhasil, navigasi ke Page_SignInActivity
                    val intent = Intent(this, Page_SignInActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Login gagal, tampilkan pesan error
                    Toast.makeText(this, "Authentication failed: ${task.exception?.message}",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    companion object {
        private const val RC_SIGN_IN = 9001 // Request code untuk Google Sign-In
    }
}