package com.hariofspades.presentation.state

class Resource<out T> constructor(
        val state: ResourceState,
        val data: T?,
        val message: String?
) {


}