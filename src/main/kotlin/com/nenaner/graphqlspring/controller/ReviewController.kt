package com.nenaner.graphqlspring.controller

import com.nenaner.graphqlspring.model.Review
import com.nenaner.graphqlspring.repositoy.ReviewRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.*


@Controller
class ReviewController(repository: ReviewRepository) {
    private val repository: ReviewRepository

    init {
        this.repository = repository
    }

    @QueryMapping
    fun allReviews(): Iterable<Review?> {
        return repository.findAll()
    }

    @QueryMapping
    fun getReview(@Argument id: Int): Optional<Review?> {
        return repository.findById(id)
    }
}
