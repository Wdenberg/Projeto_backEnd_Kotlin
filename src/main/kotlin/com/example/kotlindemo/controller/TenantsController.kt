package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.Tenants
import com.example.kotlindemo.repository.TenantsRepository
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
class TenantsController(private val tenantsRepository: TenantsRepository) {

    @GetMapping("/tenants")
    fun getAllTenants() : List<Tenants> = tenantsRepository.findAll()

    @GetMapping("/tenants/{id}")
    fun getTenantsById(@PathVariable(value = "id") tenantsId: Long) : ResponseEntity<Tenants>{
        return tenantsRepository.findById(tenantsId).map {
            tenants -> ResponseEntity.ok(tenants)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/tenants")
    fun createNewTenants(@Valid @RequestBody tenants: Tenants) : Tenants = tenantsRepository.save(tenants)

    @PutMapping("tenants/{id}")
    fun updateTenantsById(@PathVariable(value = "id")tenantsId: Long,
                          @Valid @RequestBody newTenants: Tenants
    ): ResponseEntity<Tenants>{
        return tenantsRepository.findById(tenantsId).map { existingTenants -> val updateTenants: Tenants = existingTenants.copy(slug = newTenants.slug, status = newTenants.status, name = newTenants.name
        , mainColor = newTenants.mainColor, email = newTenants.email, password = newTenants.password)
            ResponseEntity.ok().body(tenantsRepository.save(updateTenants))
        }.orElse(ResponseEntity.notFound().build())

        }

    @DeleteMapping("tenants/{id}")
    fun deleteTenantsById(@PathVariable(value = "id")id: Long): ResponseEntity<Void>{
        return tenantsRepository.findById(id).map { tenants -> tenantsRepository.delete(tenants)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
    }
