package com.proyecto.backend.controller

import com.proyecto.backend.model.Empleado
import com.proyecto.backend.service.EmpleadoService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/empleados")
class EmpleadoController(
    private val empleadoService: EmpleadoService
){
    @GetMapping
    fun listar(): List<Empleado> = empleadoService.listar()

    @PostMapping
    fun crear(@RequestBody empleado: Empleado): Empleado = empleadoService.crear(empleado)

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long):Empleado = empleadoService.obtenerPorId(id)

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id:Long,@RequestBody datos:Empleado):Empleado{
        val empleado= empleadoService.obtenerPorId(id)
        val actualizado = empleado.copy(idEmpleado = datos.idEmpleado, nombreEmpleado = datos.nombreEmpleado, correoEmpleado = datos.correoEmpleado)
        return empleadoService.crear(actualizado)}

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id:Long){
        empleadoService.eliminar(id)
    }
}