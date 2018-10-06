package com.hariofspades.blockchain.feature.list

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hariofspades.blockchain.R
import com.hariofspades.presentation.model.TransactionView
import java.util.*

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    var transactions: List<TransactionView> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.transaction_item, parent, false))
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = transactions[position]

        holder.apply {
            status.text = item.operation
            result.text = item.result.toEngineeringString()
            hash.text = item.hash
            date.text = convertToDate(item.time)
            fee.text = String.format(this.fee.context.getString(R.string.fee_holder, item.fee))
            action.text = this.action.context.getText(setRespectiveAction(item.action))
            status.setTextColor(ContextCompat.getColor(this.status.context,
                    setRespectiveColor(item.action)))
            view.setBackgroundColor(ContextCompat.getColor(this.status.context, setRespectiveColor(item.action)))
        }
    }

    private fun convertToDate(stamp: Long): String {
        val cal = Calendar.getInstance(Locale.ENGLISH)
        cal.timeInMillis = stamp * 1000L
        return DateFormat.format("dd MMM yyyy", cal).toString()
    }

    private fun setRespectiveColor(action: Boolean): Int = if (action) R.color.colorAccent else R.color.orange

    private fun setRespectiveAction(action: Boolean): Int = if (action) R.string.credit_action else R.string.debit_action

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val action: TextView = view.findViewById(R.id.action)
        val result: TextView = view.findViewById(R.id.result)
        val date: TextView = view.findViewById(R.id.date)
        val status: TextView = view.findViewById(R.id.status)
        val fee: TextView = view.findViewById(R.id.fee)
        val view: View = view.findViewById(R.id.view)
        val hash: TextView = view.findViewById(R.id.hash)
    }

}