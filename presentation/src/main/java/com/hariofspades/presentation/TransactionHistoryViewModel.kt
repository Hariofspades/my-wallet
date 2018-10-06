package com.hariofspades.presentation


import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hariofspades.domain.interactor.list.GetTransactions
import com.hariofspades.domain.model.TxHistory
import com.hariofspades.presentation.mapper.TransactionHistoryViewMapper
import com.hariofspades.presentation.mapper.TransactionItemViewMapper
import com.hariofspades.presentation.model.TxHistoryView
import com.hariofspades.presentation.state.Resource
import com.hariofspades.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver

class TransactionHistoryViewModel(
        private val getTransactions: GetTransactions,
        private val mapper: TransactionHistoryViewMapper
): ViewModel() {

    private val liveData: MutableLiveData<Resource<TxHistoryView>> = MutableLiveData()

    /**
     * One way of surviving config changes, to fetch things in view model, it preserves as it has
     * different lifecycle
     */
    init {
        fetchTransactions(SAMPLE_XPUB)
    }

    fun getTxHistory(): MutableLiveData<Resource<TxHistoryView>> {
        return liveData
    }

    fun fetchTransactions(xPub: String) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getTransactions.execute(TransactionHistorySubscriber(),
                GetTransactions.Params.forTransactions(xPub))
    }

    inner class TransactionHistorySubscriber : DisposableObserver<TxHistory>() {

        override fun onComplete() { } //did not find use-case at the moment

        override fun onNext(t: TxHistory) {
            liveData.postValue(
                    Resource(ResourceState.SUCCESS, mapper.mapToView(t), null)
            )
        }

        override fun onError(e: Throwable) {
            liveData.postValue(
                    Resource(ResourceState.ERROR, null, e.message)
            )
        }

    }

    // For the sake of this example, I'm hardcoding the xPub address
    companion object {
        const val SAMPLE_XPUB = "xpub6CfLQa8fLgtouvLxrb8EtvjbXfoC1yqzH6YbTJw4dP7s" +
                "rt523AhcMV8Uh4K3TWSHz9oDWmn9MuJogzdGU3ncxkBsAC9wFBLmFrWT9Ek81kQ"
    }
}