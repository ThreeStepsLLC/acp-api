package com.threesteps.acpapi.dto

data class UserPermissionManyRequest @JvmOverloads constructor(
    var userId: String? = null,
    var permissions: List<String> = ArrayList()
) {
}