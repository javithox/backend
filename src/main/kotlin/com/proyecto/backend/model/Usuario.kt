package com.proyecto.backend.model

import jakarta.persistence.*;

@Entity
@Table(name="Usuarios")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long = 0,

    @Column(nullable = false)
    val nombre:String = "",

    @Column(nullable = false , unique = true)
    val rutUsuario:String = "",

    @Column(nullable = false, unique = true)
    val correo: String= ""

)