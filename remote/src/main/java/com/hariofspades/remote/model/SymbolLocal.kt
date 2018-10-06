package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class SymbolLocal(@SerializedName("symbol")
                       val symbol: String,
                       @SerializedName("code")
                       val code: String,
                       @SerializedName("symbolAppearsAfter")
                       val symbolAppearsAfter: Boolean = false,
                       @SerializedName("name")
                       val name: String,
                       @SerializedName("local")
                       val local: Boolean,
                       @SerializedName("conversion")
                       val conversion: Double)