package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class CreateVacancyRequest @JvmOverloads constructor(

    var fullName: String? = null,
    var mail: String? = null,
    var city: String? = null,
    var phone: String? = null,
    var position: PositionDto? = null,
    var cvFilePath: String? = null,
    var createDate: LocalDateTime? = null

) {
}