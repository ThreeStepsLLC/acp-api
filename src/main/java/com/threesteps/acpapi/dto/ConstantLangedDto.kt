package com.threesteps.acpapi.dto

data class ConstantLangedDto @JvmOverloads constructor(

    var id: String? = null,
    var title: String? = null,
    var description1: String? = null,
    var description2: String? = null,
    var imageUrl: String? = null,
    var mediaContentUrl1: String? = null,
    var mediaContentUrl2: String? = null,
    var youTubeLink1: String? = null,
    var youTubeLink2: String? = null
) {
}