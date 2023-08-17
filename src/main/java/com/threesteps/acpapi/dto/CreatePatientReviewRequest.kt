package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class CreatePatientReviewRequest @JvmOverloads constructor(

    var descriptionEN: String? = null,
    var descriptionAZ: String? = null,
    var descriptionRU: String? = null,
    var imageUrl: String? = null,
    var createDate: LocalDateTime? = null,
    var status: Boolean? = null

) {
}