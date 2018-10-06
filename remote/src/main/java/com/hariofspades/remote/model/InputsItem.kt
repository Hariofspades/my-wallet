package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class InputsItem(@SerializedName("sequence")
                      val sequence: Long,
                      @SerializedName("witness")
                      val witness: String,
                      @SerializedName("prev_out")
                      val prevOut: PrevOut,
                      @SerializedName("script")
                      val script: String)