package com.threesteps.acpapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "service_description")
data class ServiceDescription @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String? = null,

    @Column(columnDefinition = "TEXT")
    var descriptionAz: String? = null,

    @Column(columnDefinition = "TEXT")
    var descriptionEn: String? = null,

    @Column(columnDefinition = "TEXT")
    var descriptionRu: String? = null

)
