package com.nenaner.graphqlspring.repositoy

import com.nenaner.graphqlspring.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product?, Int?>
