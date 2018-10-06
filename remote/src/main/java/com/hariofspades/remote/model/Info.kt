package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class Info(@SerializedName("nconnected")
                val nconnected: Int,
                @SerializedName("symbol_local")
                val symbolLocal: SymbolLocal,
                @SerializedName("symbol_btc")
                val symbolBtc: SymbolBtc,
                @SerializedName("latest_block")
                val latestBlock: LatestBlock,
                @SerializedName("conversion")
                val conversion: Int)