package com.nenaner.graphqlspring.config

import com.nenaner.graphqlspring.model.*
import com.nenaner.graphqlspring.repositoy.CustomerRepository
import com.nenaner.graphqlspring.repositoy.OrderRepository
import com.nenaner.graphqlspring.repositoy.ProductRepository
import com.nenaner.graphqlspring.repositoy.ReviewRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.LocalDate


@Component
class DatabaseInit(
    productRepository: ProductRepository,
    orderRepository: OrderRepository,
    customerRepository: CustomerRepository,
    reviewRepository: ReviewRepository
) :
    ApplicationRunner {
    private val productRepository: ProductRepository
    private val orderRepository: OrderRepository
    private val customerRepository: CustomerRepository
    private val reviewRepository: ReviewRepository

    init {
        this.productRepository = productRepository
        this.orderRepository = orderRepository
        this.customerRepository = customerRepository
        this.reviewRepository = reviewRepository
    }

    @Throws(Exception::class)
    override fun run(args: ApplicationArguments?) {
        val classic = Product("Classic Waffle", "Classic Sweet Cream Waffle")
        val pecan = Product("Pecan Waffle", "Sweet Cream Waffle made with delicious Pecan Pieces")
        val chocolateChip = Product("Chocolate Chip Waffle", "Sweet Cream Waffle covered in Chocolate Chips")
        val peanutButter = Product("Peanut Butter Chip Waffle", "Sweet Cream Waffle covered in Peanut Butter Chips")
        productRepository.saveAll(listOf(classic, pecan, chocolateChip, peanutButter))
        val dan = Customer("Dan", "Vega", "danvega@gmail.com")
        customerRepository.save(dan)
        val one = Order(1, LocalDate.now(), OrderStatus.PENDING, classic, dan)
        orderRepository.save(one)
        val review = Review("The best waffle ever!!!", ReviewStatus.PENDING, classic, dan)
        reviewRepository.save(review)
    }
}
