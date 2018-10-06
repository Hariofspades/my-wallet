package com.hariofspades.presentation.mapper

interface DomainViewMapper<in D, out V> {

    fun mapToView(domain: D): V
}