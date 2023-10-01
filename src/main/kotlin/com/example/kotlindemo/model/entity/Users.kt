package com.example.kotlindemo.model.entity

import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.NotBlank


@Lazy
@Entity
data class Users (

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @OneToMany(mappedBy = "user")
    val addresses: List<UserAddresses> = ArrayList(),

    @OneToMany(mappedBy = "user")
    val orders: List<Orders> = ArrayList(),

    @get:NotBlank
    val name: String? = null,

    @get: NotBlank
    val email: String? = null,

    @get: NotBlank
    val password: String? = null,
)


