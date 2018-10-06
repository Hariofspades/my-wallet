package com.hariofspades.presentation.model

import java.math.BigDecimal

data class TxHistoryView(
        val finalBalance: BigDecimal,
        val transactions: List<TransactionView>
)