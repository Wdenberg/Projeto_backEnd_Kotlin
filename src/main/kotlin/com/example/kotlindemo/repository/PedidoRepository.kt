package com.example.kotlindemo.repository



import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PedidoRepository : JpaRepository<Pedidos,Long>