package com.example.kotlindemo.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
 data class Tenants (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get:NotBlank
    val slug: String = "",

    @get:NotBlank
    val status: String? = "",

    @get:NotBlank
    val name: String? = "",

    @Column(name = "main_color")
    val mainColor: String = "",

    val email: String = "",

    @Column(name = "password")
    val password: String = ""
)