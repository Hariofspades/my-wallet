package com.hariofspades.remote.mapper

import com.hariofspades.domain.model.TxHistory
import com.hariofspades.remote.extension.toBTC
import com.hariofspades.remote.model.TransactionResponse

class TransactionHistoryMapper(
        private val transactionItemMapper: TransactionItemMapper
): RemoteDomainMapper<TransactionResponse, TxHistory> {

    override fun mapFromResponse(model: TransactionResponse): TxHistory {
        return TxHistory(
                model.wallet.finalBalance.toBTC(),
                model.txs.map(transactionItemMapper::mapFromResponse)
        )
    }
}