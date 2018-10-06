package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class AddressesItem(@SerializedName("final_balance")
                         val finalBalance: Int?,
                         @SerializedName("address")
                         val address: String?,
                         @SerializedName("account_index")
                         val accountIndex: Int?,
                         @SerializedName("n_tx")
                         val nTx: Int?,
                         @SerializedName("gap_limit")
                         val gapLimit: Int?,
                         @SerializedName("total_sent")
                         val totalSent: Int?,
                         @SerializedName("total_received")
                         val totalReceived: Int?,
                         @SerializedName("change_index")
                         val changeIndex: Int?)