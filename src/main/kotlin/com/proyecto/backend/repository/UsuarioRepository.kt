package com.proyecto.backend.repository

import com.proyecto.backend.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario ,Long>