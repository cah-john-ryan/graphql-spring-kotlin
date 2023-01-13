package com.nenaner.graphqlspring.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "orders")
class Order {
    @Id
    @GeneratedValue
    var id: Int? = null
    var qty: Int? = null
    var orderedOn: LocalDate? = null
    var status: OrderStatus? = null

    @ManyToOne
    var product: Product? = null

    @ManyToOne
    var customer: Customer? = null

    constructor()

    constructor(qty: Int?, orderedOn: LocalDate?, status: OrderStatus?, product: Product?, customer: Customer?): this() {
        this.qty = qty
        this.orderedOn = orderedOn
        this.status = status
        this.product = product
        this.customer = customer
    }
}
