package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class SymbolBtc(@SerializedName("symbol")
                     val symbol: String,
                     @SerializedName("code")
                     val code: String,
                     @SerializedName("symbolAppearsAfter")
                     val symbolAppearsAfter: Boolean,
                     @SerializedName("name")
                     val name: String,
                     @SerializedName("local")
                     val local: Boolean,
                     @SerializedName("conversion")
                     val conversion: Int)