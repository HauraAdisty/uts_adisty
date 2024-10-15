package com.haura.uts_adisty

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haura.uts_adisty.Adapter.ItemAdapter
import com.haura.uts_adisty.Model.ItemModel

class Order : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var iconAdapter: ItemAdapter
    private var itemList = mutableListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        recyclerView = findViewById(R.id.rvOrder)
        //ini kita bikin array data
        val listBuku = listOf(
            ItemModel(namaMenu = "Chicken Curry", R.drawable.chikengulai, "29 Nov, 01:20 PM", "$50.50", "2 items"),
            ItemModel(namaMenu = "Burger", R.drawable.burger, "29 Nov, 01:20 PM", "$50.50", "2 items"),
            ItemModel(namaMenu = "Coffe macha", R.drawable.esmacha, "29 Nov, 01:20 PM", "$50.50", "2 items"),

            )
        val nBukuAdapter = ItemAdapter(listBuku)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@Order)
            adapter = nBukuAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}