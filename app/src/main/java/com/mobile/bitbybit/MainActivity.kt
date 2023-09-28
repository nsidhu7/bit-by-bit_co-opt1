package com.mobile.bitbybit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mobile.bitbybit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // On clicking button load images from internet
        binding.button.setOnClickListener {

            val url = "https://picsum.photos/200" //declaring url

            //Pass the context of activity

            Glide.with(this)
                .load(url)
                .fitCenter()
                .skipMemoryCache(true)  // skip cache to load new pic
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.placeholderimg) //while loading default image appears
                .into(binding.imageView)

        }
    }
}