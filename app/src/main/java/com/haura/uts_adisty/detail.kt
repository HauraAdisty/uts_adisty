package com.haura.uts_adisty

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detail : AppCompatActivity() {
    private lateinit var btncancel: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val nama = intent.getStringExtra("namaMakanan")
        val Photo = intent.getIntExtra("photoMakanan",0)

        val txtnama = findViewById<TextView>(R.id.textViewTitle)
        val imgphoto = findViewById<ImageView>(R.id.imageViewDetail)

        txtnama.text = nama
        imgphoto.setImageResource(Photo)

        btncancel=findViewById(R.id.btnCancel)
        btncancel.setOnClickListener(){
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}
