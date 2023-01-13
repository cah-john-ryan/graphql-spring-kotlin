package com.nenaner.graphqlspring.controller

import com.nenaner.graphqlspring.model.Customer
import com.nenaner.graphqlspring.model.Order
import com.nenaner.graphqlspring.repositoy.CustomerRepository
import com.nenaner.graphqlspring.repositoy.OrderRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class CustomerController(repository: CustomerRepository, orderRepository: OrderRepository) {
    private val repository: CustomerRepository
    private val orderRepository: OrderRepository

    init {
        this.repository = repository
        this.orderRepository = orderRepository
    }

    @QueryMapping
    fun allCustomers(): List<Customer> {
        return repository.findAll()
    }

    @QueryMapping
    fun findCustomerByLastName(@Argument last: String): Customer? {
        return repository.findByLastName(last)
    }

    @SchemaMapping
    fun orders(customer: Customer): List<Order> {
        return orderRepository.findByCustomer(customer)
    }
}
