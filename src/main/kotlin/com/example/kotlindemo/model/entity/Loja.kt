package com.example.kotlindemo.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany


@Entity
data class Loja(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idLoja: Long = 0,

    @OneToMany(targetEntity = Produto::class)
    val produto: List<Produto>
)
