package com.example.testaddfragment.data.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testaddfragment.R
import com.example.testaddfragment.screen.home.HomeFragment

class adapter(var context: Context, var array: ArrayList<categories>) :
    RecyclerView.Adapter<adapter.ViewHolder>() {
    lateinit var downloadImageRecipes: DownloadImageRecipes

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtname = itemView.findViewById(R.id.txtname) as TextView
        var txtdes = itemView.findViewById(R.id.txtdes) as TextView
        var txtid = itemView.findViewById(R.id.txtid) as TextView
        var img    = itemView.findViewById(R.id.imgPicture) as ImageView

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.item_categories, p0, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val categories: categories = array[p1]
        p0.txtid.text = categories.idCategory
        p0.txtname.text = categories.strCategory
        p0.txtdes.text = categories.strCategoryDescription
        DownloadImageRecipes {
            p0.img.setImageBitmap(it)
        }.execute(categories.strCategoryThumb)
    }

    override fun getItemCount(): Int {
        return array.size
    }
}