package com.example.chatcompose.model

//faz parte do RecyclerView
data class User (
    val name: String? = null,
    val photo: Int? = null //img interna retorna como Inteiro se fosse da net seria String
)