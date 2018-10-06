package com.hariofspades.presentation.data

import com.hariofspades.domain.model.Transactions
import com.hariofspades.domain.model.TxHistory
import com.hariofspades.presentation.model.TransactionView
import com.hariofspades.presentation.model.TxHistoryView

object DataFactoryOutlet {

    fun makeTxHistoryView(): TxHistoryView {
        return TxHistoryView(
                DataFactory.randomBigDecimal(),
                makeTransactionViewList(3)
        )
    }

    fun makeTransactionViewList(count: Int): List<TransactionView> {
        val transaction = mutableListOf<TransactionView>()
        repeat(count) {
            transaction.add(makeTransactionView())
        }

        return transaction
    }

    fun makeTransactionView(): TransactionView {
        return TransactionView(
                DataFactory.randomBoolean(),
                DataFactory.randomString(),
                DataFactory.randomBigDecimal(),
                DataFactory.randomLong(),
                DataFactory.randomBigDecimal(),
                DataFactory.randomString()
        )
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