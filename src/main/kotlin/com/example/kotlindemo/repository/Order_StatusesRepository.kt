package com.example.kotlindemo.repository

import com.example.kotlindemo.model.entity.Order_statuses
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Order_StatusesRepository : JpaRepository<Order_statuses,Long>
