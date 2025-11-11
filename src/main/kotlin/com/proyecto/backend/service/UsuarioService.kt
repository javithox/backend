package com.proyecto.backend.service

import com.proyecto.backend.model.Usuario
import com.proyecto.backend.repository.UsuarioRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@Service
class UsuarioService(val usuarioRepository: UsuarioRepository) {
    fun listar():List<Usuario> = usuarioRepository.findAll()

    fun obtenerPorId(@PathVariable id:Long):Usuario=usuarioRepository.findById(id).orElseThrow { RuntimeException("Usuario no encontrado") }

    fun crear(@RequestBody usuario: Usuario):Usuario = usuarioRepository.save(usuario)

    fun eliminar(@PathVariable id:Long) = usuarioRepository.deleteById(id)
}