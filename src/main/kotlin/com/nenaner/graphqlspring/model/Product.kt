package com.nenaner.graphqlspring.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Product {
    @Id
    @GeneratedValue
    var id: Int? = null
    var title: String? = null
    var desc: String? = null

    @OneToMany(mappedBy = "product")
    private val orders: Set<Order> = HashSet()

    constructor()

    constructor(title: String?, desc: String?): this() {
        this.title = title
        this.desc = desc
    }

    constructor(id: Int?, title: String?, desc: String?): this() {
        this.id = id
        this.title = title
        this.desc = desc
    }
}
