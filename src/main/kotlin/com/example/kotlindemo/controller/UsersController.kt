package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.Users
import com.example.kotlindemo.model.requeste.Login
import com.example.kotlindemo.model.response.BaseResponse
import com.example.kotlindemo.repository.UsersRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class UsersController(private  val usersRepository: UsersRepository) {


    // localhost:8080/api/usuario
    @GetMapping("/usuario")
    fun getAllUser(): List<Users> = usersRepository.findAll()


    // localhost:8080/api/usuario/1
    @GetMapping("/usuario/{id}")
    fun getUsuarioById(@PathVariable(value = "id") id: Long): ResponseEntity<Users>{
        return usersRepository.findById(id).map {
                user -> ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }



    @PostMapping("/usuario")
    fun createNewUser(@Valid @RequestBody user: Users): Users = usersRepository.save(user)

    @PutMapping("/usuario/{id}")
    fun updateUserById(@PathVariable(value = "id") userId: Long,
                       @Valid @RequestBody newUser: Users
    ): ResponseEntity<Users>{
        return  usersRepository.findById(userId).map { existingUser -> val updateUser: Users = existingUser.copy(name = newUser.name,email = newUser.email, password = newUser.password)
            ResponseEntity.ok().body(usersRepository.save(updateUser))
        }.orElse(ResponseEntity.notFound().build())
    }


    @DeleteMapping("/usuario/{id}")

    fun deleteUserById(@PathVariable(value = "id") id: Long): ResponseEntity<Void>{
        return usersRepository.findById(id).map { user -> usersRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody login: Login): ResponseEntity<BaseResponse<Users?>>{
        val usuario =
            usersRepository.findByEmail(email = login.email) // wdeasasdasddasd
        usuario?.let {  usuario ->
            if (login.password == usuario.password){ ///asasdad
                return BaseResponse.createResponse(
                    isError = false,
                    data = usuario,
                    code = HttpStatus.OK
                )
            }else{
                return BaseResponse.createResponse()
            }
        }?: run {
            return BaseResponse.createResponse(

            )
        }
    }


}