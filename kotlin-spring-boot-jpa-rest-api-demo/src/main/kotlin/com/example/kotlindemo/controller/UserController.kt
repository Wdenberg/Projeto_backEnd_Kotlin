package com.example.kotlindemo.controller

import com.example.kotlindemo.model.User
import com.example.kotlindemo.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import kotlin.contracts.contract

class UserController(private  val userRepository: UserRepository) {

    @GetMapping("/user")
    fun getAllUser(): List<User> = userRepository.findAll()

    @GetMapping("/user")
    fun getUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<User>{
        return userRepository.findById(userId).map {
                user -> ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PostMapping("/user")
    fun createNewUser(@Valid @RequestBody user: User): User = userRepository.save(user)

    @PutMapping("/user/{id}")
    fun updateUserById(@PathVariable(value = "id") userId: Long,
                       @Valid @RequestBody newUser: User): ResponseEntity<User>{
        return  userRepository.findById(userId).map { existingUser -> val updateUser: User = existingUser.copy(email = newUser.email, password = newUser.password)
            ResponseEntity.ok().body(userRepository.save(updateUser))
        }.orElse(ResponseEntity.notFound().build())
    }


    @DeleteMapping("/user/{id}")

    fun deleteUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<Void>{
        return userRepository.findById(userId).map { user -> userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}