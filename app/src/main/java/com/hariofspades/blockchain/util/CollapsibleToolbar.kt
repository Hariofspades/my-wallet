package com.hariofspades.blockchain.util

import android.content.Context
import android.support.constraint.motion.MotionLayout
import android.support.design.widget.AppBarLayout
import android.util.AttributeSet

/**
 * This class allows us to mimic collapsing toolbar effect using motion layout.
 * Very helpful in performing complex and meaningful motions in animations
 */
class CollapsibleToolbar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), AppBarLayout.OnOffsetChangedListener {

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }
}