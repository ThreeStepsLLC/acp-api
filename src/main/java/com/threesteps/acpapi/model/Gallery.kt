package com.threesteps.acpapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
@Table(name = "galleries")
data class Gallery @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String? = null,

    var title: String? = null,

    var imageUrl: String? = null,

    var createDate: LocalDateTime? = null,

    var status: Boolean? = null

) {
}