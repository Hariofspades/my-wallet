package com.hariofspades.blockchain.inject

import com.hariofspades.blockchain.UiThread
import com.hariofspades.blockchain.base.BaseModelFactory
import com.hariofspades.domain.executor.PostExecutionThread
import com.hariofspades.domain.interactor.list.GetTransactions
import com.hariofspades.domain.repository.TransactionRemote
import com.hariofspades.presentation.TransactionHistoryViewModel
import com.hariofspades.presentation.mapper.TransactionHistoryViewMapper
import com.hariofspades.presentation.mapper.TransactionItemViewMapper
import com.hariofspades.remote.TransactionRemoteImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val presentationModule = Kodein.Module("Presentation Module") {

    import(remoteModule)

    bind<PostExecutionThread>() with provider { UiThread() }

    bind<GetTransactions>() with provider { GetTransactions(instance(), instance()) }

    bind<TransactionItemViewMapper>() with singleton { TransactionItemViewMapper() }

    bind<TransactionHistoryViewMapper>() with singleton { TransactionHistoryViewMapper(instance()) }

    bind<TransactionHistoryViewModel>() with provider {
        TransactionHistoryViewModel(instance(), instance())
    }

    bind<BaseModelFactory>() with singleton { BaseModelFactory(instance(), instance()) }
}