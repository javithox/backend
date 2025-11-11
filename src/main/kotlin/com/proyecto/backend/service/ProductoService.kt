package com.proyecto.backend.service

import com.proyecto.backend.model.Producto
import com.proyecto.backend.repository.ProductoRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@Service
class ProductoService(val productoRepository: ProductoRepository) {
    fun listar():List<Producto> = productoRepository.findAll()

    fun obtenerPorId(@PathVariable id:Long): Producto =productoRepository.findById(id).orElseThrow { RuntimeException("Usuario no encontrado") }

    fun crear(@RequestBody producto: Producto): Producto = productoRepository.save(producto)

    fun eliminar(@PathVariable id:Long) = productoRepository.deleteById(id)
}