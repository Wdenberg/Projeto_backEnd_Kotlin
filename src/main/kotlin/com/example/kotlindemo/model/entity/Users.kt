package com.example.kotlindemo.model.entity

import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.NotBlank


@Lazy
@Entity
data class Users (

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @get:NotBlank
    val name: String? = null,

    @get: NotBlank
    val email: String? = null,

    @get: NotBlank
    val password: String? = null,

    //@OneToMany com mappedBy pra indicar que o relacionamento é do tipo um pra muitos,
    //e que a propriedade addresses na classe Users mapeia o relacionamento.
    @OneToMany(mappedBy = "user")
    val addresses: List<UserAddresses> = ArrayList()

)


