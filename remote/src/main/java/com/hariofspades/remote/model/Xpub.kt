package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class Xpub(@SerializedName("path")
                val path: String,
                @SerializedName("m")
                val m: String)