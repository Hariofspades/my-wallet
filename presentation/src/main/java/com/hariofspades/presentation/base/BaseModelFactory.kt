package com.hariofspades.blockchain.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.hariofspades.domain.interactor.list.GetTransactions
import com.hariofspades.presentation.TransactionHistoryViewModel
import com.hariofspades.presentation.mapper.TransactionHistoryViewMapper

class BaseModelFactory(
        private val getTransactions: GetTransactions,
        private val mapper: TransactionHistoryViewMapper
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(TransactionHistoryViewModel::class.java)) {
            return TransactionHistoryViewModel(getTransactions, mapper) as T
        }

        throw IllegalArgumentException("Unknown ViewModel")
    }
}