package com.threesteps.acpapi.dto

data class CreateProjectImageRequest @JvmOverloads constructor(

    var path: String? = null,
    var project: ProjectDto? = null

) {
}