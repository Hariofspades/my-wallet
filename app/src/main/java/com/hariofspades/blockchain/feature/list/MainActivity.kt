package com.hariofspades.blockchain.feature.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.hariofspades.blockchain.R
import com.hariofspades.blockchain.base.BaseModelFactory
import com.hariofspades.presentation.TransactionHistoryViewModel
import com.hariofspades.presentation.model.TransactionView
import com.hariofspades.presentation.model.TxHistoryView
import com.hariofspades.presentation.state.Resource
import com.hariofspades.presentation.state.ResourceState
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.toolbar_header.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import ru.bullyboo.text_animation.TextCounter

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()

    // retrival through kodein
    private val factory: BaseModelFactory by instance()
    private val txAdapter: TransactionAdapter by instance()

    private lateinit var viewModel: TransactionHistoryViewModel
    private var skeleton: RecyclerViewSkeletonScreen? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initRecyclerView()
    }

    private fun initSkeleton() {
        skeleton = Skeleton.bind(recycler_view)
                .adapter(txAdapter)
                .load(R.layout.skeleton_item)
                .shimmer(false)
                .count(5)
                .show()
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = txAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, factory)
                .get(TransactionHistoryViewModel::class.java)

        // observing for handling the states
        viewModel.getTxHistory().observe(this, Observer {
            it?.let {
                handleState(it)
            }
        })
    }


    /**
     * Handling states
     * SUCCESS -> hides skeleton and populates item in recyclerview
     * ERROR -> shows the illustration that what you requested has been taken away
     * LOADING -> shows the skeleton loading
     */
    private fun handleState(resource: Resource<TxHistoryView>) {
        when(resource.state) {

            ResourceState.SUCCESS -> {
                resource.data?.let {
                    no_content.visibility = View.GONE
                    skeleton?.hide()
                    setupWalletBalance(it.finalBalance.toString())
                    populateList(it.transactions)
                }
            }

            ResourceState.ERROR -> {
                no_content.visibility = View.VISIBLE
                skeleton?.hide()
            }

            ResourceState.LOADING -> {
                no_content.visibility = View.GONE
                initSkeleton()
            }
        }
    }

    private fun populateList(list: List<TransactionView>) {
        txAdapter.apply { transactions = list }.also { it.notifyDataSetChanged() }
    }

    /**
     * Animation counter for showing the wallet balance.
     * Builder methods are straight-fwd
     */
    private fun setupWalletBalance(amount: String) {
        TextCounter.newBuilder().setTextView(balance)
                .setType(TextCounter.DOUBLE)
                .setMode(TextCounter.ACCELERATION_DECELERATION_MODE)
                .setDuration(1000)
                .setRound(8)
                .setPrefix("\u20BF ")
                .from(0.00000000)
                .to(amount.toDouble())
                .build()
                .start()
    }
}
