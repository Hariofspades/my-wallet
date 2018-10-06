package com.hariofspades.remote.mapper

interface RemoteDomainMapper<in R, out D> {

    fun mapFromResponse(model: R): D
}