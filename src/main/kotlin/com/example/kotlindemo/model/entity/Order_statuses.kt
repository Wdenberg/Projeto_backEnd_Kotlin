package com.example.kotlindemo.model.entity

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

class Order_statuses (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get:NotBlank
    val status: String = "",

    @get:NotBlank
    val created_at: String = "",

)