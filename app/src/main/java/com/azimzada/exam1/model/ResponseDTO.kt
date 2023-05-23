package com.azimzada.exam1.model

import java.io.Serializable

data class ResponseDTO(
    var results : List<MovieDTO>
) :Serializable