package com.threesteps.acpapi.dto

import java.time.LocalDateTime

data class ProjectGalleryDetailLangedDto @JvmOverloads constructor(

    var id: String? = null,
    var title: String? = null,
    var address: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    var createDate: LocalDateTime? = null,
    var status: Boolean? = null,
    var galleryImages: List<ProjectImageViewDto>? = ArrayList(),
    var projectDetails: List<ProjectDetailLangedViewDto>? = ArrayList()

) {
}