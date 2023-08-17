package com.threesteps.acpapi.dto

data class UserPasswordDto @JvmOverloads constructor(

    var id: String? = null,
    var username: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var password: String? = null,
    var status: Boolean? = null

) {
}