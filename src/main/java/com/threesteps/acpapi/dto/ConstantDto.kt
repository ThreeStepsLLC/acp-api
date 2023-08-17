package com.threesteps.acpapi.dto

data class ConstantDto @JvmOverloads constructor(

    var id: String? = null,
    var titleEN: String? = null,
    var titleAZ: String? = null,
    var titleRU: String? = null,
    var descriptionEN1: String? = null,
    var descriptionEN2: String? = null,
    var descriptionAZ1: String? = null,
    var descriptionAZ2: String? = null,
    var descriptionRU1: String? = null,
    var descriptionRU2: String? = null,
    var imageUrl: String? = null,
    var mediaContentUrl1: String? = null,
    var mediaContentUrl2: String? = null,
    var youTubeLink1: String? = null,
    var youTubeLink2: String? = null

) {
}