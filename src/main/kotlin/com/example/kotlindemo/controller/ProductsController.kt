package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.Products
import com.example.kotlindemo.repository.ProductsRepository
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
class ProductsController (private val productsRepository: ProductsRepository) {

    @GetMapping("/produto")
    fun getAllProduto() : List<Products> = productsRepository.findAll()


        @GetMapping("/produto/{id}")
        fun getProdutoById(@PathVariable(value = "id") produtoId: Long) : ResponseEntity<Products>{
            return productsRepository.findById(produtoId).map {
                produto -> ResponseEntity.ok(produto)
            }.orElse(ResponseEntity.notFound().build())
        }

        @PostMapping("/produto")
        fun createNewProduto(@Valid @RequestBody products: Products) : Products = productsRepository.save(products)

        @PutMapping("/produto/{id}")
        fun updateProdutoById(@PathVariable(value = "id")produtoId: Long,
                              @Valid @RequestBody newProducts: Products
        ): ResponseEntity<Products>{
            return productsRepository.findById(produtoId).map {
                existingProduto -> val updateProducts: Products = existingProduto.copy(name = newProducts.name,img = newProducts.img, description = newProducts.description, price = newProducts.price)
                ResponseEntity.ok().body(productsRepository.save(updateProducts))
            }.orElse(ResponseEntity.notFound().build())
        }
        @DeleteMapping("/produto/{id}")
        fun deleteProdutoById(@PathVariable(value = "id")produtoId: Long) : ResponseEntity<Void>{
            return productsRepository.findById(produtoId).map {
                produto -> productsRepository.delete(produto)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())
        }

}