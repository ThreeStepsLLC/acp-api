package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class UsefulInfoDto @JvmOverloads constructor(

    var id: String? = null,
    var titleEN: String? = null,
    var titleAZ: String? = null,
    var titleRU: String? = null,
    var descriptionEN: String? = null,
    var descriptionAZ: String? = null,
    var descriptionRU: String? = null,
    var imageUrl: String? = null,
    var createDate: LocalDateTime? = null,
    var status: Boolean? = null

) {
}