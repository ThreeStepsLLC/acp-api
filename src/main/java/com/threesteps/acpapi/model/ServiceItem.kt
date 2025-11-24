package com.threesteps.acpapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
@Table(name = "service_items")
data class ServiceItem @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String? = null,

    var titleAz: String? = null,

    var titleEn: String? = null,

    var titleRu: String? = null,

    @Column(columnDefinition = "TEXT")
    var descriptionAz: String? = null,

    @Column(columnDefinition = "TEXT")
    var descriptionEn: String? = null,

    @Column(columnDefinition = "TEXT")
    var descriptionRu: String? = null,

    var iconUrl: String? = null,

    var orderNumber: Int? = null,

    var createDate: LocalDateTime? = null,

    var status: Boolean? = null

) {
}
