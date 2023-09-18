package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.UserAddresses
import com.example.kotlindemo.repository.UserAddressesRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")

class UserAddressesController(private val userAddressesRepository: UserAddressesRepository) {
    @GetMapping("/useraddresses")
    fun getAllUserAddresses(): List<UserAddresses> = userAddressesRepository.findAll()
}