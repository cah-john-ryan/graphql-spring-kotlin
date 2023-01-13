package com.nenaner.graphqlspring.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Review {
    @Id
    @GeneratedValue
    var id: Int? = null
    var content: String? = null
    var status: ReviewStatus? = null

    @ManyToOne
    var product: Product? = null

    @ManyToOne
    var customer: Customer? = null

    constructor()

    constructor(content: String?, status: ReviewStatus?, product: Product?, customer: Customer?): this() {
        this.content = content
        this.status = status
        this.product = product
        this.customer = customer
    }
}
