package com.example.kotlindemo.repository

import com.example.kotlindemo.model.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<Usuario, Long>{
    fun findByEmail(email: String): Usuario?
}