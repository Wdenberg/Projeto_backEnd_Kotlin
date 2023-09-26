package com.example.kotlindemo.model.entity

import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.validation.constraints.NotBlank

@Entity
class Orders (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToMany
    @get:NotBlank
    val payment_method: String = "",

    @get:NotBlank
    val payment_method_return: Float,

    @get:NotBlank
    val delivery_price: Float,

    @get:NotBlank
    val subtotal: Float,

    @get:NotBlank
    val order_date: String = "",

    @get:NotBlank
    val status: String = ""
)