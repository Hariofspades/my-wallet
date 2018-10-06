package com.hariofspades.domain.model

import java.math.BigDecimal

data class TxHistory(
        val finalBalance: BigDecimal,
        val transactions: List<Transactions>
)