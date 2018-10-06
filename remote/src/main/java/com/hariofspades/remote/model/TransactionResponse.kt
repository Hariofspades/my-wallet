package com.hariofspades.remote.model

import com.google.gson.annotations.SerializedName

data class TransactionResponse(@SerializedName("recommend_include_fee")
                               val recommendIncludeFee: Boolean,
                               @SerializedName("addresses")
                               val addresses: List<AddressesItem>?,
                               @SerializedName("wallet")
                               val wallet: Wallet,
                               @SerializedName("txs")
                               val txs: List<TxsItem>,
                               @SerializedName("info")
                               val info: Info)