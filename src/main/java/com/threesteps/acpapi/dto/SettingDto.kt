package com.threesteps.acpapi.dto

data class SettingDto @JvmOverloads constructor(

    var id: String? = null,
    var defaultLanguage: String? = null,
    var mailAdressForContact: String? = null,
    var phone: String? = null,
    var facebook: String? = null,
    var linkedin: String? = null,
    var instagram: String? = null,
    var youTube: String? = null,
    var status: Boolean? = null

) {
}