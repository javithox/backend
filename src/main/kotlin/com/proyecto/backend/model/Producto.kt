package com.proyecto.backend.model

import jakarta.persistence.*


@Entity
@Table(name = "Productos")
data class Producto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idProducto:Int=0,

    @Column(nullable = false)
    val nomnbreProducto:String = "",

    @Column(nullable = false , unique = true)
    val precioProducto:Int = 0
)