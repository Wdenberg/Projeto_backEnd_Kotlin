package com.example.kotlindemo.repository

import com.example.kotlindemo.model.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : JpaRepository<Users, Long>{

    fun findByEmail(email: String): Users?

}