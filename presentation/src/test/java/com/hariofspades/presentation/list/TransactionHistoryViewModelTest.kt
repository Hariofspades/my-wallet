package com.hariofspades.presentation.list

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.hariofspades.domain.interactor.list.GetTransactions
import com.hariofspades.domain.model.TxHistory
import com.hariofspades.presentation.TransactionHistoryViewModel
import com.hariofspades.presentation.data.DataFactory
import com.hariofspades.presentation.data.DataFactoryOutlet
import com.hariofspades.presentation.mapper.TransactionHistoryViewMapper
import com.hariofspades.presentation.model.TxHistoryView
import com.hariofspades.presentation.state.ResourceState
import com.nhaarman.mockitokotlin2.*
import io.reactivex.observers.DisposableObserver
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Captor

@RunWith(JUnit4::class)
class TransactionHistoryViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()

    var getTransactions: GetTransactions = mock()
    var mapper: TransactionHistoryViewMapper = mock()

    var viewModel = TransactionHistoryViewModel(getTransactions, mapper)
    val params = DataFactory.randomString()

    @Captor
    val captor = argumentCaptor<DisposableObserver<TxHistory>>()

    @Test
    fun `fetch transaction executes use case`() {
        viewModel.fetchTransactions(params)

        verify(getTransactions, times(1)).execute(any(), eq(GetTransactions.Params.forTransactions(params)))
    }

    @Test
    fun `fetch transaction returns sucess`() {
        val domain = DataFactoryOutlet.makeTxHistory()
        val view = DataFactoryOutlet.makeTxHistoryView()

        stubTransactionMapperMapToView(domain, view)

        viewModel.fetchTransactions(params)

        verify(getTransactions).execute(captor.capture(), eq(GetTransactions.Params.forTransactions(params)))
        captor.firstValue.onNext(domain)

        assertEquals(ResourceState.SUCCESS, viewModel.getTxHistory().value?.state)
    }

    @Test
    fun `fetch transactions returns data`() {
        val domain = DataFactoryOutlet.makeTxHistory()
        val view = DataFactoryOutlet.makeTxHistoryView()

        stubTransactionMapperMapToView(domain, view)

        viewModel.fetchTransactions(params)

        verify(getTransactions).execute(captor.capture(), eq(GetTransactions.Params.forTransactions(params)))
        captor.firstValue.onNext(domain)

        assertEquals(view, viewModel.getTxHistory().value?.data)
    }

    @Test
    fun `fetch transactions returns error`() {
        viewModel.fetchTransactions(params)

        verify(getTransactions).execute(captor.capture(), eq(GetTransactions.Params.forTransactions(params)))
        captor.firstValue.onError(RuntimeException())

        assertEquals(ResourceState.ERROR, viewModel.getTxHistory().value?.state)
    }

    @Test
    fun `fetch transactions returns error message`() {
        val error = DataFactory.randomString()

        viewModel.fetchTransactions(params)

        verify(getTransactions).execute(captor.capture(), eq(GetTransactions.Params.forTransactions(params)))
        captor.firstValue.onError(RuntimeException(error))

        assertEquals(error, viewModel.getTxHistory().value?.message)
    }

    private fun stubTransactionMapperMapToView(domain: TxHistory, view: TxHistoryView) {
        whenever(mapper.mapToView(domain))
                .thenReturn(view)
    }
}