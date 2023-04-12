package com.example.kotlindemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank



@Entity
data class Usuario (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @get: NotBlank
    val email: String = "",

    @get: NotBlank
    val password: String =  ""

)