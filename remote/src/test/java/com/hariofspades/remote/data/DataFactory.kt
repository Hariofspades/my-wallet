package com.hariofspades.remote.data

import java.math.BigDecimal
import java.util.*
import java.util.concurrent.ThreadLocalRandom

object DataFactory {

    fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }

    fun randomLong(): Long {
        return randomInt().toLong()
    }

    fun randomBigDecimal(): BigDecimal {
        return randomInt().toBigDecimal()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }

}