package com.example.kotlindemo.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

import javax.persistence.OneToOne

@Entity
data class Pedidos(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idPedidos: Long = 0,


    @OneToOne(targetEntity = Loja::class)
    val loja : List<Loja>,

    @OneToMany(targetEntity = Produto::class)
    val produtos: List<Produto>
)
