package com.hariofspades.blockchain.inject.feature

import com.hariofspades.blockchain.feature.list.TransactionAdapter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

val listModule = Kodein.Module("List Module") {

    bind<TransactionAdapter>() with provider { TransactionAdapter() }
}