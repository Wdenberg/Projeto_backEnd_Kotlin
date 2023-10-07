package com.example.kotlindemo.repository

import com.example.kotlindemo.model.entity.Tenants
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TenantsRepository : JpaRepository<Tenants,Long>
