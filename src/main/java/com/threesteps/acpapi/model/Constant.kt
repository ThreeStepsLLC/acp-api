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
    var descriptionEN1: String? = null,

    @Column(length = 10000)
    var descriptionEN2: String? = null,

    @Column(length = 10000)
    var descriptionAZ1: String? = null,

    @Column(length = 10000)
    var descriptionAZ2: String? = null,

    @Column(length = 10000)
    var descriptionRU1: String? = null,

    @Column(length = 10000)
    var descriptionRU2: String? = null,

    var imageUrl: String? = null,

    var mediaContentUrl1: String? = null,

    var mediaContentUrl2: String? = null,

    var youTubeLink1: String? = null,

    var youTubeLink2: String? = null

) {
}