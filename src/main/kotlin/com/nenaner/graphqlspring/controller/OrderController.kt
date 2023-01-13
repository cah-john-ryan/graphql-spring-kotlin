package com.nenaner.graphqlspring.controller

import com.nenaner.graphqlspring.model.Order
import com.nenaner.graphqlspring.repositoy.OrderRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class OrderController(repository: OrderRepository) {
    private val repository: OrderRepository

    init {
        this.repository = repository
    }

    @QueryMapping
    fun allOrders(): Iterable<Order> {
        return repository.findAll()
    }

    @QueryMapping
    fun getOrder(@Argument id: Int): Optional<Order> {
        return repository.findById(id)
    }
}
