package com.threesteps.acpapi.dto

data class UpdatePasswordRequest @JvmOverloads constructor(
    var userId: String? = null,
    var password: String? = null
) {

}