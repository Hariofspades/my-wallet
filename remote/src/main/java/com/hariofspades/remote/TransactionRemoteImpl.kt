package com.hariofspades.remote

import com.hariofspades.domain.model.TxHistory
import com.hariofspades.domain.repository.TransactionRemote
import com.hariofspades.remote.mapper.TransactionHistoryMapper
import com.hariofspades.remote.service.TransactionHistoryService
import io.reactivex.Observable

class TransactionRemoteImpl(
        private val transactionHistoryService: TransactionHistoryService,
        private val mapper: TransactionHistoryMapper
): TransactionRemote  {

    override fun getTransactions(xPub: String): Observable<TxHistory> {
        return transactionHistoryService.getTransactionHistory(xPub)
                .map(mapper::mapFromResponse)
    }
}