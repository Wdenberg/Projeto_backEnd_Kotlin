package com.example.kotlindemo.model.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
 data class Tenants (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get:NotBlank
    val slug: String = "",

    @get:NotBlank
    val status: String = "",

    @get:NotBlank
    val name: String = "",

    @Column(name = "main_color")
    val mainColor: String = "",

    @get:NotBlank
    val email: String = "",

    @Column(name = "password")
    @get:NotBlank
    val password: String = "",
)