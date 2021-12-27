package com.example.content_providers

import android.content.Context
import android.graphics.pdf.PdfDocument
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.item_layout.view.*

class ContactAdapter(list:List<ContactDTO>,ctx:Context) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private var list:List<ContactDTO> =list
    private var context:Context=ctx

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.name.text=list[position].name
       holder.number.text=list[position].number

    }

    override fun getItemCount(): Int {
       return list.size
    }
    class ViewHolder(item: View):RecyclerView.ViewHolder(item){
        val name:TextView=item.tvName!!
        val number:TextView=item.tvNumber!!
        val phota:ImageView=item.photo
    }
}




