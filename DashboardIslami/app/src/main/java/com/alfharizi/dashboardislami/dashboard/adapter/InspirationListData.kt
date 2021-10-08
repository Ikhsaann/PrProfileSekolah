package com.alfharizi.dashboardislami.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.alfharizi.dashboardislami.R
import com.alfharizi.dashboardislami.dashboard.model.InspirationModel

class InspirationListAdapter(
    private val listInspiration:
    ArrayList<InspirationModel>
) :
    RecyclerView.Adapter<InspirationListAdapter.ListViewHolder>() {

    // class untuk mendaftarkan konponen pada layout dan memasuhkannya ke dalam variable

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // variable imgPhoto berisi komponen imageView pada layout item_row_inspiration.xml
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)
    }

    // mendaftarkan tampilan / layout untuk menampilakan data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        // variable view berisi layout yang akan menampilkan data (item_row_inspiration)
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_inspiration, parent, false)
        return ListViewHolder(view)
    }


    // memasang data ke komponen layout
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        // memasukan data berdasarkan posisinya ke dalam variable inspiration
        val inspiration = listInspiration[position]
        // menampilkan data pada variable inspiration di komponen imgPhoto
                Glide.with(holder.itemView.context)
                     .load(inspiration.InspirationImage)
                     .into(holder.imgPhoto)
    }




    //menentukan jumlah data yang ingin di tampilkan
    override fun getItemCount(): Int {
    return listInspiration.size
  }
}