package com.example.kotlindemo.repository

import com.example.kotlindemo.model.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository : JpaRepository<Produto,Long>
