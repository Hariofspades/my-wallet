package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class LatestBlock(@SerializedName("block_index")
                       val blockIndex: Int,
                       @SerializedName("time")
                       val time: Int,
                       @SerializedName("hash")
                       val hash: String,
                       @SerializedName("height")
                       val height: Int)