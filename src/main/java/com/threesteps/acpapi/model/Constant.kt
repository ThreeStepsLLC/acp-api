package com.threesteps.acpapi.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "constants")
data class Constant @JvmOverloads constructor(

    @Id
    var id: String? = null,

    var titleEN: String? = null,

    var titleAZ: String? = null,

    var titleRU: String? = null,

    @Column(length = 10000)
    var descriptionEN: String? = null,

    @Column(length = 10000)
    var descriptionAZ: String? = null,

    @Column(length = 10000)
    var descriptionRU: String? = null

) {
}