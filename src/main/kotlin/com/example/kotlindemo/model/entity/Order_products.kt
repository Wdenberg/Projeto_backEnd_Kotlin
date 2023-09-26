package com.example.kotlindemo.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Order_products (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get:NotBlank
    val product_price: Float,

    @get:NotBlank
    val quantity: Int = 0,

    )
