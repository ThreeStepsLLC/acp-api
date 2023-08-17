package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class SurgeryLangedDto @JvmOverloads constructor(

    var id: String? = null,
    var title: String? = null,
    var description: String? = null,
    var createDate: LocalDateTime? = null,
    var status: Boolean? = null,

) {
}