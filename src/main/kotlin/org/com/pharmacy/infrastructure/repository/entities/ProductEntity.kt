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
@Table(name = "products")
class ProductsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @CreationTimestamp
    val createdAt: Date,
    @UpdateTimestamp
    val updatedAt: Date,
    val name: String,
    val price: Double,
    val sku: String,
    val disabled: Boolean,
) {
}