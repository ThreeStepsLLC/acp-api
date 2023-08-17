package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class GalleryDto @JvmOverloads constructor(

    var id: String? = null,
    var title: String? = null,
    var imageUrl: String? = null,
    var createDate: LocalDateTime? = null,
    var status: Boolean? = null

) {
}