package com.threesteps.acpapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
@Table(name = "projects")
data class Project @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String? = null,

    var titleEN: String? = null,

    var titleAZ: String? = null,

    var titleRU: String? = null,

    var addressEN: String? = null,

    var addressAZ: String? = null,

    var addressRU: String? = null,

    @Column(length = 10000)
    var descriptionEN: String? = null,

    @Column(length = 10000)
    var descriptionAZ: String? = null,

    @Column(length = 10000)
    var descriptionRU: String? = null,

    var imageUrl: String? = null,

    var createDate: LocalDateTime? = null,

    var status: Boolean? = null

) {
}