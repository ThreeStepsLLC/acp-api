package com.threesteps.acpapi.dto

data class ProjectDetailLangedDto @JvmOverloads constructor(

    var id: String? = null,
    var title: String? = null,
    var description: String? = null,
    var project: ProjectDto? = null

) {
}