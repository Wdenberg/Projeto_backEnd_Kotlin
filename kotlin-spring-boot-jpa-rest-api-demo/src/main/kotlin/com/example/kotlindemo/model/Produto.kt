package com.example.kotlindemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Produto (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get:NotBlank
    val nome: String = "",

    @get:NotBlank
    val img: String = "",

    @get:NotBlank
    val preco: Double = 0.0,

    @get:NotBlank
    val descricao: String = "",


)

