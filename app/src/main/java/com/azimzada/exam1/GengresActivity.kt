package com.azimzada.exam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimzada.exam1.adapter.GengresAdapter
import com.azimzada.exam1.adapter.OnItemClickListener
import com.azimzada.exam1.adapter.PostAdapter
import com.azimzada.exam1.databinding.ActivityGengresBinding
import com.azimzada.exam1.databinding.ActivityMainBinding
import com.azimzada.exam1.model.GenreDTO
import com.azimzada.exam1.model.MovieDTO
import com.azimzada.exam1.model.ResponseDTO
import com.azimzada.exam1.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GengresActivity : AppCompatActivity() {
    lateinit var binding: ActivityGengresBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGengresBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getPosts()
    }

    fun getPosts() {
        val call: Call<GenreDTO?>? =
            RetrofitClient.getRetrofitInstance()?.getApi()
                ?.genre("4fae678e0bf0ca0ce26f68efa69e3328")
        call?.enqueue(object : Callback<GenreDTO?> {
            override fun onResponse(
                call: Call<GenreDTO?>?,
                response: Response<GenreDTO?>?
            ) {
                val postList: List<GenreDTO> = response!!.body() as List<GenreDTO>
//                var postDetail : MovieDTO  = response!!.body() as MovieDTO
                binding.recyclerView.adapter = GengresAdapter(postList)
            }

            override fun onFailure(call: Call<GenreDTO?>?, t: Throwable?) {
                Log.d("Salam", " tOAST ")
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}