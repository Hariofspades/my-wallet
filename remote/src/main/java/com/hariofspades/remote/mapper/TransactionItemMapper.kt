package com.hariofspades.remote.mapper

import com.hariofspades.domain.model.Transactions
import com.hariofspades.remote.extension.toBTC
import com.hariofspades.remote.model.TxsItem

class TransactionItemMapper: RemoteDomainMapper<TxsItem, Transactions> {

    override fun mapFromResponse(model: TxsItem): Transactions {
        return Transactions(
                action = debitOrCredit(model.result),
                result = model.result.toBTC(),
                time = model.time,
                fee = model.fee.toBTC(),
                hash = model.hash
        )
    }

    private fun debitOrCredit(result: Long): Boolean {
        return result > 0
    }
}