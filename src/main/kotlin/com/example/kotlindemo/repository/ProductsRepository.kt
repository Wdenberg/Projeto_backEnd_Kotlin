package com.example.kotlindemo.repository

import com.example.kotlindemo.model.entity.Products
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductsRepository : JpaRepository<Products,Long>
