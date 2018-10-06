package com.hariofspades.domain.test.data

import com.hariofspades.domain.model.Transactions
import com.hariofspades.domain.model.TxHistory

object DataFactoryOutlet {

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