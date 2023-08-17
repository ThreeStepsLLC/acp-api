package com.threesteps.acpapi.dto

data class CreateContactRequest @JvmOverloads constructor(

    var customerFullName: String? = null,
    var phone: String? = null,
    var mail: String? = null,
    var description: String? = null

) {
}