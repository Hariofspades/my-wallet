package com.hariofspades.remote.mapper

import com.hariofspades.remote.data.DataFactoryOutlet
import com.hariofspades.remote.extension.toBTC
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionHistoryMapperTest {

    private val itemMapper: TransactionItemMapper = mock()
    private val mapper = TransactionHistoryMapper(itemMapper)

    @Test
    fun `mapper maps data from remote to domain`() {
        val response = DataFactoryOutlet.makeTransactionResponse()
        val domain = mapper.mapFromResponse(response)

        assertEquals(domain.finalBalance, response.wallet.finalBalance.toBTC())
        assertEquals(domain.transactions, response.txs.map(itemMapper::mapFromResponse))
    }
}