package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.UserAddresses
import com.example.kotlindemo.repository.UserAddressesRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")

class UserAddressesController(private val userAddressesRepository: UserAddressesRepository) {
    @GetMapping("/useraddresses")
    fun getAllUserAddresses(): List<UserAddresses> = userAddressesRepository.findAll()

    @GetMapping("/useraddresses/{id}")
    fun getUserAddressesById(@PathVariable(value = "id")userAddressesId: Long) : ResponseEntity<UserAddresses>{
        return userAddressesRepository.findById(userAddressesId).map {
            userAddresses -> ResponseEntity.ok(userAddresses)
        }.orElse(ResponseEntity.notFound().build())
    }
    @PostMapping("/useraddresses")
    fun createNewUserAddresses(@Valid @RequestBody userAddresses: UserAddresses) : UserAddresses = userAddressesRepository.save(userAddresses)


    @PutMapping("/useraddresses/{id}")
    fun updateUserAddressesById(@PathVariable(value = "id")userAddressesId: Long,
                                @Valid @RequestBody newUserAddresses: UserAddresses
    ):ResponseEntity<UserAddresses>{
        return userAddressesRepository.findById(userAddressesId).map { existingUserAddresses -> val updateUserAddresses:
                UserAddresses = existingUserAddresses.copy(street = newUserAddresses.street, street_number = newUserAddresses.street_number
                , zipcode = newUserAddresses.zipcode,city = newUserAddresses.city, state = newUserAddresses.state, complement = newUserAddresses.complement)
                ResponseEntity.ok().body(userAddressesRepository.save(updateUserAddresses))
        }.orElse(ResponseEntity.notFound().build())

        }

    @DeleteMapping("/useraddresses/{id}")
    fun deleteUserAddressesById(@PathVariable(value = "id") id: Long): ResponseEntity<Void>{
        return userAddressesRepository.findById(id).map { userAddresses -> userAddressesRepository.delete(userAddresses)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}
