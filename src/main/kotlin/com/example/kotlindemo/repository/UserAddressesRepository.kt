package com.example.kotlindemo.repository

import com.example.kotlindemo.model.entity.UserAddresses
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserAddressesRepository : JpaRepository<UserAddresses, Long>