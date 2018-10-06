package com.hariofspades.remote.data

import com.hariofspades.domain.model.Transactions
import com.hariofspades.domain.model.TxHistory
import com.hariofspades.remote.model.*

object DataFactoryOutlet {

    fun makeTransactionResponse(): TransactionResponse {
        return TransactionResponse(
                DataFactory.randomBoolean(),
                listOf(makeAddressItem()),
                makeWallet(),
                listOf(makeTxsItem()),
                makeInfo()
        )
    }

    fun makeInfo(): Info {
        return Info(
                DataFactory.randomInt(),
                makeSymbolLocal(),
                makeSymbolBtc(),
                makeLatestBlock(),
                DataFactory.randomInt()
        )
    }

    fun makeLatestBlock(): LatestBlock {
        return LatestBlock(
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt()
        )
    }

    fun makeSymbolBtc(): SymbolBtc {
        return SymbolBtc(
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomBoolean(),
                DataFactory.randomString(),
                DataFactory.randomBoolean(),
                DataFactory.randomInt()
        )
    }

    fun makeSymbolLocal(): SymbolLocal {
        return SymbolLocal(
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomBoolean(),
                DataFactory.randomString(),
                DataFactory.randomBoolean(),
                DataFactory.randomLong().toDouble()
        )
    }

    fun makeAddressItem(): AddressesItem {
        return AddressesItem(
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt()

        )
    }

    fun makeWallet(): Wallet {
        return Wallet(
                DataFactory.randomInt(),
                DataFactory.randomLong(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt()
        )
    }

    fun makeTxsItem(): TxsItem {
        return TxsItem(
                DataFactory.randomInt(),
                listOf(makeInputsItem()),
                DataFactory.randomLong(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                listOf(makeOutItem()),
                DataFactory.randomInt(),
                DataFactory.randomLong(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomBoolean(),
                DataFactory.randomLong(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt()
        )
    }

    fun makeOutItem(): OutItem {
        return OutItem(
                DataFactory.randomBoolean(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                makeXPub(),
                DataFactory.randomInt(),
                DataFactory.randomString()
        )
    }

    fun makeInputsItem(): InputsItem {
        return InputsItem(
                DataFactory.randomLong(),
                DataFactory.randomString(),
                makePrevOut(),
                DataFactory.randomString()
        )
    }

    fun makePrevOut(): PrevOut {
        return PrevOut(
                DataFactory.randomBoolean(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                makeXPub(),
                DataFactory.randomInt(),
                DataFactory.randomString()
        )
    }

    fun makeXPub(): Xpub {
        return Xpub(DataFactory.randomString(), DataFactory.randomString())
    }

    fun makeTxHistory(): TxHistory {
        return TxHistory(
                DataFactory.randomBigDecimal(),
                makeTransactionList(3)
        )
    }

    fun makeTransactionList(count: Int): List<Transactions> {
        val transactions = mutableListOf<Transactions>();
        repeat(count) {
            transactions.add(makeTransactions())
        }

        return transactions
    }

    fun makeTransactions(): Transactions {
        return Transactions(
                DataFactory.randomBoolean(),
                DataFactory.randomBigDecimal(),
                DataFactory.randomLong(),
                DataFactory.randomBigDecimal(),
                DataFactory.randomString()
        )
    }
}