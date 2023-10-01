package com.example.kotlindemo.model.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Categories (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToMany(mappedBy = "category")
    val products: List<Products> = ArrayList(),

    @Column(name = "id_tenant")
    val id_tenant: Long? = null,

    @get:NotBlank
    val name: String = "",
)