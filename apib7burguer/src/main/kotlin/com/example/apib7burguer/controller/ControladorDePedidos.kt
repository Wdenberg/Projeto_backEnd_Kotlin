package com.example.apib7burguer.controller

class ControladorDePedidos {

    private val pedidos = mutableListOf<Pedido>()

    fun listarPedidos(): List<Pedido> {
        return pedidos.toList()
    }

    fun buscarPedido(id: Int): Pedido? {
        return pedidos.find { it.id == id }
    }

    fun criarPedido(novoPedido: Pedido) {
        pedidos.add(novoPedido)
    }

    fun atualizarPedido(id: Int, novoPedido: Pedido): Boolean {
        val index = pedidos.indexOfFirst { it.id == id }
        if (index >= 0) {
            pedidos[index] = novoPedido
            return true
        }
        return false
    }

    fun excluirPedido(id: Int): Boolean {
        val pedido = pedidos.find { it.id == id }
        return pedidos.remove(pedido)
    }

}

data class Pedido(
    val id: Int,
    val descricao: String,
    val valor: Double
)