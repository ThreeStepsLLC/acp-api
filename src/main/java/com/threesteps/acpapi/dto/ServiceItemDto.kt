package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class ServiceItemDto @JvmOverloads constructor(

    var id: String? = null,
    var titleAz: String? = null,
    var titleEn: String? = null,
    var titleRu: String? = null,
    var descriptionAz: String? = null,
    var descriptionEn: String? = null,
    var descriptionRu: String? = null,
    var iconUrl: String? = null,
    var orderNumber: Int? = null,
    var createDate: LocalDateTime? = null,
    var status: Boolean? = null

) {
}
