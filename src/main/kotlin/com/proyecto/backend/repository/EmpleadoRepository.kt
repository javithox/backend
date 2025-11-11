package com.proyecto.backend.repository

import com.proyecto.backend.model.Empleado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmpleadoRepository: JpaRepository<Empleado , Long>