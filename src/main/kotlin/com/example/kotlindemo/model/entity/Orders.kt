package com.example.kotlindemo.model.entity

import java.util.Date
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Orders (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "id_user")
    val user: Users? = null,

    @OneToMany(mappedBy = "order")
    val orderProducts: List<Order_products> = ArrayList(),

    @OneToMany(mappedBy = "order")
    val orderStatuses: List<Order_statuses> = ArrayList(),

    @OneToMany
    val payment_method: String = "",

    @ManyToOne
    @JoinColumn(name = "id_tenant")
    val tenant: Tenants? = null,

    @Column(name = "id_address")
    val id_address: Long? = null,

    @get:NotBlank
    val payment_method_return: Float,

    @get:NotBlank
    val delivery_price: Float,

    @get:NotBlank
    val subtotal: Float,

    @get:NotBlank
    val order_date: String = "",

    @get:NotBlank
    val status: String = "",
)