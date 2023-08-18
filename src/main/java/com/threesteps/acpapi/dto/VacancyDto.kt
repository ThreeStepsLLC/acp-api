package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class VacancyDto @JvmOverloads constructor(

    var id: String? = null,
    var fullName: String? = null,
    var mail: String? = null,
    var city: String? = null,
    var position: PositionDto? = null,
    var cvFilePath: String? = null,
    var createDate: LocalDateTime? = null

) {
}