package com.hariofspades.presentation.mapper

import com.hariofspades.presentation.data.DataFactoryOutlet
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionItemViewMapperTest {

    private val mapper = TransactionItemViewMapper()

    @Test
    fun `mapper maps data from domain to presentation`() {
        val domain = DataFactoryOutlet.makeTransactions()
        val view = mapper.mapToView(domain)

        assertEquals(domain.time, view.time)
        assertEquals(domain.hash, view.hash)
        assertEquals(domain.action, view.action)
        assertEquals(domain.fee, view.fee)
        assertEquals(domain.result, view.result)
    }
}