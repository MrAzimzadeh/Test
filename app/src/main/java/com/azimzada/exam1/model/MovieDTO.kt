package com.azimzada.exam1.model

import java.io.Serializable

data class MovieDTO(
    var id: Int,
    var original_language: String,
    var original_title: String,
    var overview: String,
    var video: Boolean,
    var release_date: String,
    var poster_path :String
) :Serializable