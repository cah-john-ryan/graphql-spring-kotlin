package com.nenaner.graphqlspring.repositoy

import com.nenaner.graphqlspring.model.Review
import org.springframework.data.repository.CrudRepository

interface ReviewRepository : CrudRepository<Review?, Int?>
