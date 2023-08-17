package com.threesteps.acpapi.dto

data class ApiResponseDto<T> @JvmOverloads constructor(
    var message: String? = "OK",
    var data: T
) {}
