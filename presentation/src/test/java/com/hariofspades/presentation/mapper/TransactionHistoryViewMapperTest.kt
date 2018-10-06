package com.hariofspades.presentation.mapper

import com.hariofspades.presentation.data.DataFactoryOutlet
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionHistoryViewMapperTest {

    private val itemMapper: TransactionItemViewMapper = TransactionItemViewMapper()
    private val mapper = TransactionHistoryViewMapper(itemMapper)

    @Test
    fun `mapper maps data from domain to view`() {
        val domain = DataFactoryOutlet.makeTxHistory()
        val view = mapper.mapToView(domain)

        assertEquals(domain.transactions[0].result, view.transactions[0].result)
        assertEquals(domain.transactions[0].fee, view.transactions[0].fee)
        assertEquals(domain.transactions[0].hash, view.transactions[0].hash)
        assertEquals(domain.transactions[0].action, view.transactions[0].action)
        assertEquals(domain.transactions[0].time, view.transactions[0].time)
        assertEquals(domain.finalBalance, view.finalBalance)
    }
}