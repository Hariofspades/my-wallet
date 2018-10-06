package com.hariofspades.presentation.mapper

import com.hariofspades.domain.model.TxHistory
import com.hariofspades.presentation.model.TxHistoryView

class TransactionHistoryViewMapper(
        private val transactionItemViewMapper: TransactionItemViewMapper
) : DomainViewMapper<TxHistory, TxHistoryView> {

    override fun mapToView(domain: TxHistory): TxHistoryView {
        return TxHistoryView(
                domain.finalBalance,
                domain.transactions.map(transactionItemViewMapper::mapToView)
        )
    }
}