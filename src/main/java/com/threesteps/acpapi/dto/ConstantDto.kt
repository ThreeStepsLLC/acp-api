package com.threesteps.acpapi.dto

data class ConstantDto @JvmOverloads constructor(

    var id: String? = null,
    var titleEN: String? = null,
    var titleAZ: String? = null,
    var titleRU: String? = null,
    var descriptionEN: String? = null,
    var descriptionAZ: String? = null,
    var descriptionRU: String? = null

) {
}