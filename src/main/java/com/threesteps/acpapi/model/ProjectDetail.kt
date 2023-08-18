package com.threesteps.acpapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "project_details")
data class ProjectDetail @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String? = null,

    var titleEN: String? = null,

    var titleAZ: String? = null,

    var titleRU: String? = null,

    var descriptionEN: String? = null,

    var descriptionAZ: String? = null,

    var descriptionRU: String? = null,

    @ManyToOne
    var project: Project? = null

) {
}