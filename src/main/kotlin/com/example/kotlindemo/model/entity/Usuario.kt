package com.example.kotlindemo.model.entity

import org.springframework.context.annotation.Lazy
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank


@Lazy
@Entity
data class Usuario (

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @get:NotBlank
    val nome: String? = null,
    @get: NotBlank
    val email: String? = null,

    @get: NotBlank
    val password: String? = null




)