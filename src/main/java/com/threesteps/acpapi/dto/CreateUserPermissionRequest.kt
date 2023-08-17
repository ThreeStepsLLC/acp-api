package com.threesteps.acpapi.dto

data class CreateUserPermissionRequest @JvmOverloads constructor(

    var user: UserDto? = null,
    var permission: PermissionDto? = null

) {
}