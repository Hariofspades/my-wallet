package com.hariofspades.blockchain.inject

import com.hariofspades.blockchain.BuildConfig
import com.hariofspades.domain.repository.TransactionRemote
import com.hariofspades.remote.TransactionRemoteImpl
import com.hariofspades.remote.mapper.TransactionHistoryMapper
import com.hariofspades.remote.mapper.TransactionItemMapper
import com.hariofspades.remote.service.TransactionHistoryService
import com.hariofspades.remote.service.TransactionHistoryServiceFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val remoteModule = Kodein.Module("Remote Module") {

    bind<TransactionHistoryService>() with singleton {
        TransactionHistoryServiceFactory.makeTransactionHistoryService(BuildConfig.DEBUG)
    }

    bind<TransactionItemMapper>() with singleton { TransactionItemMapper() }

    bind<TransactionHistoryMapper>() with singleton { TransactionHistoryMapper(instance()) }

    bind<TransactionRemote>() with provider { TransactionRemoteImpl(instance(), instance()) }

}