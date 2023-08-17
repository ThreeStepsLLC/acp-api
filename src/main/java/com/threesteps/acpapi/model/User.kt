package com.threesteps.acpapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "users")
data class User @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String? = null,

    var username: String? = null,

    var firstName: String? = null,

    var lastName: String? = null,

    var password: String? = null,

    var status: Boolean? = null

) {
}