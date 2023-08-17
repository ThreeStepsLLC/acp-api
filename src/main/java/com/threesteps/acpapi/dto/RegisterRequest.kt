package com.threesteps.acpapi.dto

data class RegisterRequest @JvmOverloads constructor(

    var firstName: String? = null,
    var lastName: String? = null,
    var username: String? = null,
    var password: String? = null

) {
}