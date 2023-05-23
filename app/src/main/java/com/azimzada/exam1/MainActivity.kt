package com.azimzada.exam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimzada.exam1.adapter.OnItemClickListener
//import com.azimzada.exam1.adapter.OnItemClickListener
import com.azimzada.exam1.adapter.PostAdapter
import com.azimzada.exam1.databinding.ActivityMainBinding
import com.azimzada.exam1.model.MovieDTO
import com.azimzada.exam1.model.ResponseDTO
import com.azimzada.exam1.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getPosts()
        binding.btnGoToSearch.setOnClickListener()
        {
            val newIntent = Intent(this@MainActivity , SearchActivity::class.java)
            startActivity(newIntent);
        }
        binding.GotoGengre.setOnClickListener()
        {
            val newIntent = Intent(this@MainActivity , GengresActivity::class.java)
            startActivity(newIntent);
        }
    }

    fun getPosts() {
        val call: Call<ResponseDTO?>? =
            RetrofitClient.getRetrofitInstance()?.getApi()?.getMovieList("4fae678e0bf0ca0ce26f68efa69e3328")
        call?.enqueue(object : Callback<ResponseDTO?> {
            override fun onResponse(
                call: Call<ResponseDTO?>?,
                response: Response<ResponseDTO?>?
            ) {
                val postList: ResponseDTO = response!!.body() as ResponseDTO
//                var postDetail : MovieDTO  = response!!.body() as MovieDTO
                binding.recyclerView.adapter = PostAdapter( postList.results , object : OnItemClickListener
                {
                    override fun OnItemClick(item: MovieDTO) {
                        val intent = Intent(this@MainActivity, PostActivity::class.java)
                        intent.putExtra("Post", item)
                        Log.d("Salam", "Gonder ")
                        startActivity(intent)
                    }
                })
            }

            override fun onFailure(call: Call<ResponseDTO?>?, t: Throwable?) {
                Log.d("Salam", " tOAST ")
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}