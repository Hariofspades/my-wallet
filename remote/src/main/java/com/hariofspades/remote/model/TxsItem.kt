package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class TxsItem(@SerializedName("ver")
                   val ver: Int,
                   @SerializedName("inputs")
                   val inputs: List<InputsItem>?,
                   @SerializedName("fee")
                   val fee: Long,
                   @SerializedName("weight")
                   val weight: Int,
                   @SerializedName("block_height")
                   val blockHeight: Int,
                   @SerializedName("relayed_by")
                   val relayedBy: String,
                   @SerializedName("out")
                   val out: List<OutItem>?,
                   @SerializedName("lock_time")
                   val lockTime: Int,
                   @SerializedName("result")
                   val result: Long,
                   @SerializedName("size")
                   val size: Int,
                   @SerializedName("balance")
                   val balance: Int,
                   @SerializedName("double_spend")
                   val doubleSpend: Boolean,
                   @SerializedName("time")
                   val time: Long,
                   @SerializedName("tx_index")
                   val txIndex: Int,
                   @SerializedName("vin_sz")
                   val vinSz: Int,
                   @SerializedName("hash")
                   val hash: String,
                   @SerializedName("vout_sz")
                   val voutSz: Int)