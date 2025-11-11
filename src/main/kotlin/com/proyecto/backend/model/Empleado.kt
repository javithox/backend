package com.proyecto.backend.model

import jakarta.persistence.*

@Entity
@Table(name = "Empleados")
data class Empleado(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idEmpleado:Long = 0,

    @Column(nullable = false)
    val nombreEmpleado:String = "",

    @Column(nullable = false)
    val correoEmpleado:String = ""
)