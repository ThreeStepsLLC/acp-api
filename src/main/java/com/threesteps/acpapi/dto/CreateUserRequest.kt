package com.threesteps.acpapi.dto

data class CreateUserRequest @JvmOverloads constructor(

    var username: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var password: String? = null,
    var status: Boolean? = null

) {
}