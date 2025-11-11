package com.proyecto.backend.controller

import com.proyecto.backend.model.Producto
import com.proyecto.backend.service.ProductoService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/productos")
class ProductoController(
    private val productoService: ProductoService
){
    @GetMapping
    fun listar(): List<Producto> = productoService.listar()

    @PostMapping
    fun crear(@RequestBody producto: Producto):Producto = productoService.crear(producto)

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id:Long):Producto = productoService.obtenerPorId(id)

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id:Long, @RequestBody datos:Producto):Producto{
        val producto = productoService.obtenerPorId(id)
        val actualizado = producto.copy(idProducto = datos.idProducto, nomnbreProducto = datos.nomnbreProducto, precioProducto = datos.precioProducto)
        return productoService.crear(actualizado)}

    @DeleteMapping("/{id}")
    fun eliminar (@PathVariable id:Long){
        productoService.eliminar(id)
    }
}