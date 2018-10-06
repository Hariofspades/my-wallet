package com.hariofspades.remote

import com.hariofspades.domain.model.TxHistory
import com.hariofspades.remote.data.DataFactory
import com.hariofspades.remote.data.DataFactoryOutlet
import com.hariofspades.remote.extension.toBTC
import com.hariofspades.remote.mapper.TransactionHistoryMapper
import com.hariofspades.remote.model.TransactionResponse
import com.hariofspades.remote.service.TransactionHistoryService
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionRemoteImplTest {

    private val mapper: TransactionHistoryMapper = mock()
    private val service: TransactionHistoryService = mock()

    private lateinit var transactionRemoteImpl: TransactionRemoteImpl

    @Before
    fun setup() {
        transactionRemoteImpl = TransactionRemoteImpl(service, mapper)
    }

    @Test
    fun `get transaction history completes`() {
        stubGetTransactionHistory(Observable.just(DataFactoryOutlet.makeTransactionResponse()))
        stubRemoteDomainMapping(any(), DataFactoryOutlet.makeTxHistory())

        val testObserver = transactionRemoteImpl.getTransactions(
                DataFactory.randomString()).test()
        testObserver.assertComplete()
    }

    @Test
    fun `get transaction calls server`() {
        stubGetTransactionHistory(Observable.just(DataFactoryOutlet.makeTransactionResponse()))
        stubRemoteDomainMapping(any(), DataFactoryOutlet.makeTxHistory())

        val input = DataFactory.randomString()

        transactionRemoteImpl.getTransactions(input).test()
        verify(service).getTransactionHistory(input)
    }

    @Test
    fun `get transactions return data`() {
        val response = DataFactoryOutlet.makeTransactionResponse()
        stubGetTransactionHistory(Observable.just(response))

        val domain = DataFactoryOutlet.makeTxHistory()
        stubRemoteDomainMapping(response, domain)

        val testObserver = transactionRemoteImpl.getTransactions(
                DataFactory.randomString()).test()

        testObserver.assertValue(domain)

    }

    @Test
    fun `currency conversion from statoshi to bitcoin`() {
        assertEquals(0.00110962.toBigDecimal(), 110962.toLong().toBTC())
        assertEquals(111.09621111.toBigDecimal(), 11109621111.toBTC())
    }

    private fun stubGetTransactionHistory(observable: Observable<TransactionResponse>) {
        whenever(service.getTransactionHistory(any()))
                .thenReturn(observable)

    }

    private fun stubRemoteDomainMapping(remote: TransactionResponse, domain: TxHistory) {
        whenever(mapper.mapFromResponse(remote))
                .thenReturn(domain)
    }
}