package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.Order_statuses
import com.example.kotlindemo.repository.Order_StatusesRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class Order_StatusesController(private val orderStatusesrepository: Order_StatusesRepository) {

    @GetMapping("/orderstatuses")
    fun getAllOrderStatuses(): List<Order_statuses> = orderStatusesrepository.findAll()

    @GetMapping("/orderstatuses/{id}")
    fun getOrderStatusesById(@PathVariable(value = "id") orderStatusesId: Long): ResponseEntity<Order_statuses> {
        return orderStatusesrepository.findById(orderStatusesId).map { orderStatuses ->
            ResponseEntity.ok(orderStatuses)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/orderstatuses")
    fun createNewOrderStatuses(@Valid @RequestBody orderStatuses: Order_statuses): Order_statuses =
        orderStatusesrepository.save(orderStatuses)

    @PutMapping("/orderstatuses/{id}")
    fun updateOrderStatusesById(@PathVariable(value = "id") orderStatusesId: Long,
                                @Valid @RequestBody newOrder_statuses: Order_statuses
    ): ResponseEntity<Order_statuses> {
        return orderStatusesrepository.findById(orderStatusesId).map { existingOrderStatuses -> val updateOrderStatuses: Order_statuses = existingOrderStatuses.copy(status = newOrder_statuses.status, created_at = newOrder_statuses.created_at)
            ResponseEntity.ok().body(orderStatusesrepository.save(updateOrderStatuses))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/orderstatuses/{id}")
    fun deleteOrderStatusesById(@PathVariable(value = "id")id: Long): ResponseEntity<Void>{
        return orderStatusesrepository.findById(id).map { orderStatuses -> orderStatusesrepository.delete(orderStatuses)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}
