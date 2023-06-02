package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.Produto
import com.example.kotlindemo.repository.ProdutoRepository
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
class ProdutoController (private val produtoRepository: ProdutoRepository) {

    @GetMapping("/produto")
    fun getAllProduto() : List<Produto> = produtoRepository.findAll()

    /*
        @GetMapping("/produto/{id}")
        fun getProdutoById(@PathVariable(value = "id") produtoId: Long) : ResponseEntity<Produto>{
            return produtoRepository.findById(produtoId).map {
                produto -> ResponseEntity.ok(produto)
            }.orElse(ResponseEntity.notFound().build())
        }

        @PostMapping("/produto")
        fun createNewProduto(@Valid @RequestBody produto: Produto) : Produto = produtoRepository.save(produto)

        @PutMapping("/produto/{id}")
        fun updateProdutoById(@PathVariable(value = "id")produtoId: Long,
                              @Valid @RequestBody newProduto: Produto
        ): ResponseEntity<Produto>{
            return produtoRepository.findById(produtoId).map {
                existingProduto -> val updateProduto: Produto = existingProduto.copy(nome = newProduto.nome,img = newProduto.img,descricao = newProduto.descricao, preco = newProduto.preco)
                ResponseEntity.ok().body(produtoRepository.save(updateProduto))
            }.orElse(ResponseEntity.notFound().build())
        }
        @DeleteMapping("/produto/{id}")
        fun deleteProdutoById(@PathVariable(value = "id")produtoId: Long) : ResponseEntity<Void>{
            return produtoRepository.findById(produtoId).map {
                produto -> produtoRepository.delete(produto)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())
        }
    */
}