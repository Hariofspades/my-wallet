package com.hariofspades.remote.mapper

import com.hariofspades.remote.data.DataFactoryOutlet
import com.hariofspades.remote.extension.toBTC
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionItemMapperTest {

    private val mapper = TransactionItemMapper()

    @Test
    fun `mapper maps data from remote to domain`() {
        val remote = DataFactoryOutlet.makeTxsItem()
        val domain = mapper.mapFromResponse(remote)

        assertEquals(domain.result, remote.result.toBTC())
        assertEquals(domain.action, remote.result > 0)
        assertEquals(domain.fee, remote.fee.toBTC())
        assertEquals(domain.hash, remote.hash)
        assertEquals(domain.time, remote.time)

    }
}