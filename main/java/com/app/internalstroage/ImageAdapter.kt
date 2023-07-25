package com.app.internalstroage

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.internalstroage.databinding.ImageuiBinding
import com.bumptech.glide.Glide

class ImageAdapter(var context: Context,var list: MutableList<ImageData>) :RecyclerView.Adapter<ImageAdapter.myviewholder>(){
    lateinit var binding: ImageuiBinding
    class myviewholder(var bind: ImageuiBinding):RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        binding= ImageuiBinding.inflate(LayoutInflater.from(context),parent,false)
       return myviewholder(binding)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        var image=list[position]

        Glide
            .with(context)
            .load(image.image)
            .into(holder.bind.ivImage)
        binding.cardView.setOnClickListener {
            val intent = Intent(context, ViewPagerActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("imageList", list)
            context.startActivity(intent)
        }
    }

    private fun <T> MutableList(): MutableList<T>? {
            return null
    }


    override fun getItemCount(): Int {
        return list.size
    }
}

private fun Intent.putExtra(s: String, mutableList: MutableList<ImageData>?) {

}
