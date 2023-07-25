package com.app.internalstroage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.app.internalstroage.databinding.ActivityViewPagerBinding
import com.bumptech.glide.Glide

class ViewPagerActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewPagerBinding
    private lateinit var viewPager: ViewPager2
     var imageList= mutableListOf <ImageData>()
    lateinit var padapter:ImageViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = findViewById(R.id.view_pager)

        imageList = ((intent.getSerializableExtra("imageList") as? MutableList<ImageData> ?: emptyList()).toMutableList())
        val position = intent.getIntExtra("position", 0)


       padapter= ImageViewPagerAdapter(this,imageList)
        viewPager.adapter=padapter
        viewPager.setCurrentItem(position, false)
    }
}