package com.example.apib7burguer.model

class Produto(val id: Int, val nome: String, val imagem: String, val preco: Double, val descricao: String) {

    fun Listagem() {
    }

    fun Detalhamento(idProduto: Int) {
    }

    fun VendaDeProduto(idProduto: Int, quantidade: Int) {
    }
}