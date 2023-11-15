package com.example.kotlindemo.repository

import com.example.kotlindemo.model.entity.Orders
import org.springframework.data.jpa.repository.JpaRepository

interface OrdersRepository : JpaRepository<Orders,Long>
