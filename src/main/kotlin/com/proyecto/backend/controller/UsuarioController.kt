package com.proyecto.backend.controller

import com.proyecto.backend.model.Usuario
import com.proyecto.backend.repository.UsuarioRepository
import com.proyecto.backend.service.UsuarioService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/usuarios")
class UsuarioController(
    private val usuarioService: UsuarioService
) {
    @GetMapping
    fun listar(): List<Usuario> =usuarioService.listar()

    @PostMapping
    fun crear(@RequestBody usuario: Usuario): Usuario=usuarioService.crear(usuario)

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long):Usuario=
      usuarioService.obtenerPorId(id)

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Long,@RequestBody datos:Usuario): Usuario{
        val usuario = usuarioService.obtenerPorId(id)
        val actualizado = usuario.copy(id = datos.id, nombre = datos.nombre, rutUsuario = datos.rutUsuario , correo = datos.correo)
        return usuarioService.crear(actualizado) }

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id:Long){
        usuarioService.eliminar(id)
    }

}