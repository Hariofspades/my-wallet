package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class PrevOut(@SerializedName("spent")
                   val spent: Boolean,
                   @SerializedName("tx_index")
                   val txIndex: Int,
                   @SerializedName("type")
                   val type: Int,
                   @SerializedName("addr")
                   val addr: String = "",
                   @SerializedName("value")
                   val value: Int,
                   @SerializedName("xpub")
                   val xpub: Xpub,
                   @SerializedName("n")
                   val n: Int,
                   @SerializedName("script")
                   val script: String)