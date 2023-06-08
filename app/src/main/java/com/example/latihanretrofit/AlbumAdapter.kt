package com.example.latihanretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class AlbumAdapter(var con: Context, var list: List<AlbumsItem>):RecyclerView.Adapter<AlbumAdapter.MyViewHolder>(){

    private var data = emptyList<AlbumsItem>()

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var id = itemView.findViewById<TextView>(R.id.tv_id)
        var userId = itemView.findViewById<TextView>(R.id.tv_userid)
        var title = itemView.findViewById<TextView>(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.custom,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text = list[position].id.toString()
        holder.userId.text = list[position].userId.toString()
        holder.title.text = list[position].title.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_tanggal).text = getCurrentDate()
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    private fun getCurrentDate():String{
        val dateFormat = SimpleDateFormat("yyyy/MM/dd",Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
    }



}