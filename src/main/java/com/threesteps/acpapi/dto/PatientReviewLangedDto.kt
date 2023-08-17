package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class PatientReviewLangedDto @JvmOverloads constructor(
    var id: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    var createDate: LocalDateTime? = null,
    var status: Boolean? = null
) {

}
