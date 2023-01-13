package com.nenaner.graphqlspring.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Customer {
    @Id
    @GeneratedValue
    var id: Int? = null
    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null

    constructor()

    constructor(firstName: String?, lastName: String?, email: String?) : this() {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }
}
