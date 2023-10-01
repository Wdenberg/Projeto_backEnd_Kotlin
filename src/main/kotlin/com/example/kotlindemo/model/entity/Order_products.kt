package com.example.kotlindemo.model.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Order_products (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get:NotBlank
    val product_price: Float,

    @get:NotBlank
    val quantity: Int = 0,

    //muitos pra um entre Order_products e Products
    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Products? = null

    )
