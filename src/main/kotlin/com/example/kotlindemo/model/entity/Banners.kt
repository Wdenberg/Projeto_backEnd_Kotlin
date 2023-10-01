package com.example.kotlindemo.model.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Banners (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "id_tenant")
    val tenant: Tenants? = null,

    @get: NotBlank
    val img: String = ""
)