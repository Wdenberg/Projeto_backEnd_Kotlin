package com.example.kotlindemo.model.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Products (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get:NotBlank
    val name: String = "",

    @get:NotBlank
    val img: String = "",

    @get:NotBlank
    val price: Double? = 00.00,

    @get:NotBlank
    val description: String = "",

)

