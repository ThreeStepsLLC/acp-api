package com.threesteps.acpapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "settings")
data class Setting @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
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