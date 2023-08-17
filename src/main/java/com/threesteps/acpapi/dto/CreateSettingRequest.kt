package com.threesteps.acpapi.dto

data class CreateSettingRequest @JvmOverloads constructor(

    var defaultLanguage: String? = null,
    var mailAddressForContact: String? = null,
    var officeAddress: String? = null,
    var phone: String? = null,
    var facebook: String? = null,
    var linkedin: String? = null,
    var instagram: String? = null,
    var youTube: String? = null,
    var totalProjects: String? = null,
    var totalRoad: String? = null,
    var totalTunnels: String? = null,
    var totalBridges: String? = null

) {
}