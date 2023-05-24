package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.Usuario
import com.example.kotlindemo.model.requeste.Login
import com.example.kotlindemo.model.response.BaseResponse
import com.example.kotlindemo.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Email
import kotlin.math.log


@RestController
@RequestMapping("/api")
class UserController(private  val userRepository: UserRepository) {

    @GetMapping("/usuario")
    fun getAllUser(): List<Usuario> = userRepository.findAll()



    @GetMapping("/usuario/{id}")
    fun getUsuarioById(@PathVariable(value = "id") id: Long): ResponseEntity<Usuario>{
        return userRepository.findById(id).map {
                user -> ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PostMapping("/usuario")
    fun createNewUser(@Valid @RequestBody user: Usuario): Usuario = userRepository.save(user)

    @PutMapping("/usuario/{id}")
    fun updateUserById(@PathVariable(value = "id") userId: Long,
                       @Valid @RequestBody newUser: Usuario
    ): ResponseEntity<Usuario>{
        return  userRepository.findById(userId).map { existingUser -> val updateUser: Usuario = existingUser.copy(email = newUser.email, password = newUser.password)
            ResponseEntity.ok().body(userRepository.save(updateUser))
        }.orElse(ResponseEntity.notFound().build())
    }


    @DeleteMapping("/usuario/{id}")

    fun deleteUserById(@PathVariable(value = "id") id: Long): ResponseEntity<Void>{
        return userRepository.findById(id).map { user -> userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody login: Login): ResponseEntity<BaseResponse<Usuario?>>{
        val usuario =
            userRepository.findByEmail(email = login.email)
        usuario?.let {  usuario ->
            if (login.password == usuario.password){
                return BaseResponse.createResponse(
                    isError = false,
                    data = usuario,
                    code = HttpStatus.OK
                )
            }else{
                return BaseResponse.createResponse()
            }
        }?: run {
            return BaseResponse.createResponse()
        }
    }


}