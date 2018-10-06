package com.hariofspades.presentation.mapper

import com.hariofspades.domain.model.Transactions
import com.hariofspades.presentation.model.TransactionView
import java.text.DateFormat
import java.text.SimpleDateFormat

class TransactionItemViewMapper : DomainViewMapper<Transactions, TransactionView> {

    override fun mapToView(domain: Transactions): TransactionView {
        return TransactionView(
                domain.action,
                creditOrDebit(domain.action),
                domain.result,
                domain.time,
                domain.fee,
                domain.hash
        )
    }

    private fun creditOrDebit(action: Boolean): String = if (action) "Credit" else "Debit"

}