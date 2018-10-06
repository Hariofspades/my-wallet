package com.hariofspades.domain.test.interactor.list

import com.hariofspades.domain.executor.PostExecutionThread
import com.hariofspades.domain.interactor.list.GetTransactions
import com.hariofspades.domain.repository.TransactionRemote
import com.hariofspades.domain.test.data.DataFactory
import com.hariofspades.domain.test.data.DataFactoryOutlet
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class GetTransactionsTest {

    private lateinit var getTransactions: GetTransactions

    @Mock
    private lateinit var transactionRemote: TransactionRemote

    @Mock
    private lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getTransactions = GetTransactions(transactionRemote, postExecutionThread)
    }

    @Test
    fun `get transaction completes`() {
        whenever(transactionRemote.getTransactions(any()))
                .thenReturn(Observable.just(DataFactoryOutlet.makeTxHistory()))

        val testObserver = getTransactions.buildUseCaseObservable(
                GetTransactions.Params.forTransactions(DataFactory.randomString())).test()

        testObserver.assertComplete()
    }

    @Test
    fun `get transaction returns a value`() {
        val txHistory = DataFactoryOutlet.makeTxHistory()

        whenever(transactionRemote.getTransactions(any()))
                .thenReturn(Observable.just(txHistory))

        val testObserver = getTransactions.buildUseCaseObservable(
                GetTransactions.Params.forTransactions(DataFactory.randomString())).test()

        testObserver.assertValue(txHistory)
    }

    @Test(expected=IllegalArgumentException::class)
    fun `get transaction throws exception`() {
        getTransactions.buildUseCaseObservable().test()
    }
}