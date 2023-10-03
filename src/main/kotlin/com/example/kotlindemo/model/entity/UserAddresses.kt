package com.example.kotlindemo.model.entity

import org.springframework.context.annotation.Lazy
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotBlank

@Entity
@Lazy

data class UserAddresses(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "id_users")
    val user: Users? = null,

    @get:NotBlank
    @Column(name = "id_district")
    val id_district: Long? = null,

    @get:NotBlank
    val street: String = "",

    @get:NotBlank
    val street_number: String = "",

    @get:NotBlank
    val zipcode: String = "",

    @get:NotBlank
    val city: String = "",

    @get:NotBlank
    val state: String = "",

    @get:NotBlank
    val complement: String = "",
)