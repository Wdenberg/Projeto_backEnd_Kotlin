package com.example.kotlindemo.repository



import com.example.kotlindemo.model.entity.Pedidos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PedidoRepository : JpaRepository<Pedidos,Long>