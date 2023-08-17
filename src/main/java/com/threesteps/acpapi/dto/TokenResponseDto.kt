package com.threesteps.acpapi.dto

data class TokenResponseDto @JvmOverloads constructor(

    var firstName: String? = null,
    var lastName: String? = null,
    var token: String? = null,
    var permissions: List<PermissionDto> = ArrayList()

) {
}