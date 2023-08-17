package com.threesteps.acpapi.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "user_permissions")
data class UserPermission @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String? = null,

    @ManyToOne
    var user: User? = null,

    @ManyToOne
    var permission: Permission? = null

) {
}