package com.threesteps.acpapi.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "permissions")
data class Permission @JvmOverloads constructor(

    @Id
    var id: String? = null,

    var title: String? = null

) {
}