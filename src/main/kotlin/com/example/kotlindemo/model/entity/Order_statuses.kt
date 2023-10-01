package com.example.kotlindemo.model.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Order_statuses (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "id_order")
    val order: Orders? = null,

    @get:NotBlank
    val status: String = "",

    @get:NotBlank
    val created_at: String = "",
)