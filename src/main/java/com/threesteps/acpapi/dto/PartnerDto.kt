package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class PartnerDto @JvmOverloads constructor(

    var id: String? = null,
    var title: String? = null,
    var imageUrl: String? = null,
    var createDate: LocalDateTime? = null,
    var status: Boolean? = null

) {
}