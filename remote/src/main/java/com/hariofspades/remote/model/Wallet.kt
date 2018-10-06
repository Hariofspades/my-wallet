package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class Wallet(@SerializedName("n_tx_filtered")
                  val nTxFiltered: Int,
                  @SerializedName("final_balance")
                  val finalBalance: Long,
                  @SerializedName("n_tx")
                  val nTx: Int,
                  @SerializedName("total_sent")
                  val totalSent: Int,
                  @SerializedName("total_received")
                  val totalReceived: Int)