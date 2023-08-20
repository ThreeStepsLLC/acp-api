package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class CreateProjectRequest @JvmOverloads constructor(

    var titleEN: String? = null,
    var titleAZ: String? = null,
    var titleRU: String? = null,
    var addressEN: String? = null,
    var addressAZ: String? = null,
    var addressRU: String? = null,
    var descriptionEN: String? = null,
    var descriptionAZ: String? = null,
    var descriptionRU: String? = null,
    var progress: Double? = null,
    var imageUrl: String? = null,
    var createDate: LocalDateTime? = null,
    var status: Boolean? = null,
    var projectDetails: List<CreateProjectDetailRequest>? = ArrayList()

) {
}