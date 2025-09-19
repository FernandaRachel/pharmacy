package org.com.org.com.pharmacy.infrastructure.repository.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.time.Instant

@Entity
class PharmacyEntity : Serializable {

    @Id
    @GeneratedValue
    private val id: Long? = null

    @CreationTimestamp
    var createdTime: Instant? = null

    @UpdateTimestamp
    var updatedTime: Instant? = null

    var name: String? = null
    var address: String? = null
    var country: String? = null
    var city: String? = null


    protected constructor() {
        // no-args constructor required by JPA spec
        // this one is protected since it should not be used directly
    }

//    constructor(name: String?, state: String?) {
//        this.name = name
//        this.state = state
//    }

}
