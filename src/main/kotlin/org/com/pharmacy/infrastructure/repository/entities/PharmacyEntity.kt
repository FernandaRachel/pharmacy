package org.com.pharmacy.infrastructure.repository.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.com.org.com.pharmacy.domain.model.Pharmacy
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.time.Instant
/**
 * Why data class is problematic with JPA ?
 * Hibernate proxies
 * - Hibernate often creates proxies (subclasses) of your entity for lazy loading.
 * - data class makes your class final by default, preventing subclassing. (Yes, you can use the Kotlin all-open compiler plugin, but it’s an extra dependency.)
 * */
@Entity
@Table(name = "pharmacies")
class PharmacyEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var address: String = "",

    @Column(nullable = false)
    var country: String = "",

    @Column(nullable = false)
    var city: String = "",

    @CreationTimestamp
    @Column(updatable = false)
    var createdTime: Instant? = null,

    @UpdateTimestamp
    var updatedTime: Instant? = null
)


fun PharmacyEntity.toPharmacy(): Pharmacy {
    return Pharmacy(id = id, name = name, address = address, country = country, city = city)
}

fun Pharmacy.toEntity(): PharmacyEntity {
    return PharmacyEntity(name = name, address = address, country = country, city = city)
}
