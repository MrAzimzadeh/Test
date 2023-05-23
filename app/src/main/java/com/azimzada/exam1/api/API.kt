package com.azimzada.exam1.api

import com.azimzada.exam1.model.GenreDTO
import com.azimzada.exam1.model.MovieDTO
import com.azimzada.exam1.model.ResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("3/movie/popular")
    fun getMovieList(@Query("api_key") api_key: String): Call<ResponseDTO?>?

    @GET("3/genre/movie")
    fun genre(@Query("list") list: String): Call<GenreDTO?>?

}