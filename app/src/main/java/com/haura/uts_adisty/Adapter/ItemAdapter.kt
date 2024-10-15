package com.haura.uts_adisty.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.haura.uts_adisty.Model.ItemModel
import com.haura.uts_adisty.R
import com.haura.uts_adisty.detail

class ItemAdapter(
    private val itemOrder: List<ItemModel>) :
    RecyclerView.Adapter<ItemAdapter.BukuAdapterHolder>() {

    //view holder yang digunakan unutk menyimpan referensi layout item
    class BukuAdapterHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgMenu: ImageView = itemView.findViewById(R.id.imgMenu)
        val txtNamamenu: TextView = itemView.findViewById(R.id.tvNamaMenu)
        val txttanggal: TextView = itemView.findViewById(R.id.tvTanggal)
        val txtharga: TextView = itemView.findViewById(R.id.tvharga)
        val txtitem: TextView = itemView.findViewById(R.id.tvItems)
    }

    //pengaturan data item pada setiap list dari recycle view
    override fun onBindViewHolder(holder: BukuAdapterHolder, position: Int) {
        val currentItem = itemOrder[position]
        holder.imgMenu.setImageResource(currentItem.imageMenu)
        holder.txtNamamenu.setText(currentItem.namaMenu)
        holder.txttanggal.setText(currentItem.Tanggal)
        holder.txtharga.setText(currentItem.Harga)
        holder.txtitem.setText(currentItem.totalItem)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, detail::class.java).apply {
                // Mengirim data melalui intent
                putExtra("namaMakanan", currentItem.namaMenu)
                putExtra("photoMakanan", currentItem.imageMenu)
            }
            context.startActivity(intent)
        }
    }

    //membuat layout list item sebagai item dari recycle view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuAdapterHolder {

        // Inflate layout item_destination.xml (pastikan file XML ini ada)
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_list, parent, false)
        return BukuAdapterHolder(nView)
    }

    //mengembalikan panjang nilai dari data
    override fun getItemCount(): Int{
        return itemOrder.size
    }


}