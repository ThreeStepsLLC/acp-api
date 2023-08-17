package com.threesteps.acpapi.dto

data class UserPermissionDto @JvmOverloads constructor(

    var id: String? = null,
    var user: UserDto? = null,
    var permission: PermissionDto? = null

) {
}