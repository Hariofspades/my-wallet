package com.hariofspades.domain.interactor.list

import com.hariofspades.domain.executor.PostExecutionThread
import com.hariofspades.domain.interactor.ObservableUseCase
import com.hariofspades.domain.model.TxHistory
import com.hariofspades.domain.repository.TransactionRemote
import io.reactivex.Observable

class GetTransactions(
        private val transactionRemote: TransactionRemote,
        postExecutionThread: PostExecutionThread
): ObservableUseCase<TxHistory, GetTransactions.Params>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Params?): Observable<TxHistory> {
        if (params == null) throw IllegalArgumentException("Params can't be null")
        return transactionRemote.getTransactions(params.xPub)
    }

    data class Params constructor(val xPub: String) {
        companion object {
            fun forTransactions(xPub: String): Params {
                return Params(xPub)
            }
        }
    }
}