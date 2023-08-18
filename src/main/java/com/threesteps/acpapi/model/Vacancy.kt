package com.threesteps.acpapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
@Table(name = "vacancies")
data class Vacancy @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String? = null,

    var fullName: String? = null,

    var mail: String? = null,

    var city: String? = null,

    @ManyToOne
    var position: Position? = null,

    var cvFilePath: String? = null,

    var createDate: LocalDateTime? = null
) {
}