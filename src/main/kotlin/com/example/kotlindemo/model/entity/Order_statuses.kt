package com.example.kotlindemo.model.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Order_statuses (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get:NotBlank
    val status: String = "",

    @get:NotBlank
    val created_at: String = "",

    @ManyToOne
    @JoinColumn(name = "order_id")
    val order: Orders? = null,
)