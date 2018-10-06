package com.hariofspades.blockchain

import com.hariofspades.domain.executor.PostExecutionThread
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Scheduler
import javax.inject.Inject

class UiThread : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}