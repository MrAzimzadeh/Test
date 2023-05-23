package com.azimzada.exam1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azimzada.exam1.databinding.ActivityPostBinding
import com.azimzada.exam1.model.MovieDTO
import com.squareup.picasso.Picasso

class PostActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPostBinding
    lateinit var post: MovieDTO
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPostBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = intent
        post = intent.getSerializableExtra("Post") as MovieDTO
        binding.titleTV.setText(post.original_title)
        binding.Date.setText(post.release_date)
        binding.DetailDescTV.setText(post.overview)
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${post.poster_path}" )
            .into(binding.DetailImaage)
    }
}