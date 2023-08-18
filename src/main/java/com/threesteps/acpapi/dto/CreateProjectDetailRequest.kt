package com.threesteps.acpapi.dto

data class CreateProjectDetailRequest @JvmOverloads constructor(

    var titleEN: String? = null,
    var titleAZ: String? = null,
    var titleRU: String? = null,
    var descriptionEN: String? = null,
    var descriptionAZ: String? = null,
    var descriptionRU: String? = null,
    var project: ProjectDto? = null

) {
}