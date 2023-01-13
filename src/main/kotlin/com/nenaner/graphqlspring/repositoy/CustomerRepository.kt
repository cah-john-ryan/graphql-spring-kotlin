package com.nenaner.graphqlspring.repositoy

import com.nenaner.graphqlspring.model.Customer
import org.springframework.data.repository.Repository

interface CustomerRepository : Repository<Customer?, Int?> {
    fun findAll(): List<Customer?>?
    fun findByLastName(last: String?): Customer?
    fun save(customer: Customer?)
}
