package com.nenaner.graphqlspring.repositoy

import com.nenaner.graphqlspring.model.Customer
import com.nenaner.graphqlspring.model.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Int> {
    fun findByCustomer(customer: Customer): List<Order>
}
