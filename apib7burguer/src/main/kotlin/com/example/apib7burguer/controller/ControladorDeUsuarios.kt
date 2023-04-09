package com.example.apib7burguer.controller

class ControladorDeUsuarios {

    private val usuarios = mutableListOf<String>()

    fun buscarUsuario(nome: String): String? {
        return usuarios.find { it == nome }
    }

    fun criarUsuario(nome: String) {
        usuarios.add(nome)
    }

    fun atualizarUsuario(nomeAntigo: String, nomeNovo: String) {
        val index = usuarios.indexOf(nomeAntigo)
        if (index >= 0) {
            usuarios[index] = nomeNovo
        }
    }

    fun excluirUsuario(nome: String) {
        usuarios.remove(nome)
    }

}