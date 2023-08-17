package com.threesteps.acpapi.dto

data class LoginDto @JvmOverloads constructor(

    var username: String? = null,
    var password: String? = null

) {
}
