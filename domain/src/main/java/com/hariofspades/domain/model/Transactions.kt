package com.hariofspades.domain.model

import java.math.BigDecimal

data class Transactions(
        val action: Boolean,
        val result: BigDecimal,
        val time: Long,
        val fee: BigDecimal,
        val hash: String
)