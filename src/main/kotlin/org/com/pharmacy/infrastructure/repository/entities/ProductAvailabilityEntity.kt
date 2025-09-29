package org.com.pharmacy.infrastructure.repository.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.Date

@Entity
@Table(name = "product_availability")
class ProductAvailabilityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @CreationTimestamp
    val createdAt: Date? = null,

    @UpdateTimestamp
    val updatedAt: Date? = null,
    val productId: Long = -1,
    val quantity: Int = -1
)
