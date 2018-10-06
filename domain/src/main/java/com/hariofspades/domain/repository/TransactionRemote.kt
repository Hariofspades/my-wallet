package com.hariofspades.domain.repository

import com.hariofspades.domain.model.TxHistory
import io.reactivex.Observable

interface TransactionRemote {

    fun getTransactions(xPub: String): Observable<TxHistory>
}