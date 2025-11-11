package com.proyecto.backend.service

import com.proyecto.backend.model.Empleado
import com.proyecto.backend.repository.EmpleadoRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@Service
class EmpleadoService(val empleadoRepository: EmpleadoRepository) {
    fun listar():List<Empleado> = empleadoRepository.findAll()

    fun obtenerPorId(@PathVariable id:Long): Empleado =empleadoRepository.findById(id).orElseThrow { RuntimeException("Usuario no encontrado") }

    fun crear(@RequestBody empleado: Empleado): Empleado = empleadoRepository.save(empleado)

    fun eliminar(@PathVariable id:Long) = empleadoRepository.deleteById(id)
}