package com.hariofspades.remote.service

import com.hariofspades.remote.model.TransactionResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TransactionHistoryService {

    @GET("multiaddr")
    fun getTransactionHistory(@Query("active") xPub: String): Observable<TransactionResponse>
}