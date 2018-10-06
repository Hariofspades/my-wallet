package com.hariofspades.presentation.model

import java.math.BigDecimal

data class TransactionView(
        val action: Boolean,
        val operation: String,
        val result: BigDecimal,
        val time: Long,
        val fee: BigDecimal,
        val hash: String
)