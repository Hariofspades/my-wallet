package com.hariofspades.remote.extension

import java.math.BigDecimal
import java.math.RoundingMode

fun Long.toBTC(): BigDecimal {
    return (this.toDouble() / 100000000.toDouble()).toBigDecimal().setScale(8, RoundingMode.HALF_EVEN)
}