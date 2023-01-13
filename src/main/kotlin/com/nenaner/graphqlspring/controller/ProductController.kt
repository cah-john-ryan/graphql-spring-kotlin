package com.nenaner.graphqlspring.controller

import com.nenaner.graphqlspring.model.Product
import com.nenaner.graphqlspring.repositoy.ProductRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class ProductController(repository: ProductRepository) {
    private val repository: ProductRepository

    init {
        this.repository = repository
    }

    @QueryMapping
    fun allProducts(): Iterable<Product> {
        return repository.findAll()
    }

    @QueryMapping
    fun getProduct(@Argument id: Int): Optional<Product> {
        return repository.findById(id)
    }
}
