package com.threesteps.acpapi.dto

data class ProjectImageDto @JvmOverloads constructor(

    var id: String? = null,
    var path: String? = null,
    var project: ProjectDto? = null

) {
}