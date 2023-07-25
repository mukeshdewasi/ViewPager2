package com.app.internalstroage

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.internalstroage.databinding.ActivityViewPagerBinding
import com.app.internalstroage.databinding.ViewpageruiBinding
import com.bumptech.glide.Glide

class ImageViewPagerAdapter(var context: Context,var list: MutableList<ImageData>) : RecyclerView.Adapter<ImageViewPagerAdapter.MyViewHolder>() {
    class MyViewHolder(var bind: ViewpageruiBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ViewpageruiBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageData = list[position]
        Glide
            .with(context)
            .load(imageData.image)
            .into(holder.bind.ivImage)
        Log.e("TAG", "loadImagesFromStorage: $list")
    }

    override fun getItemCount(): Int {
        return list.size
    }
}