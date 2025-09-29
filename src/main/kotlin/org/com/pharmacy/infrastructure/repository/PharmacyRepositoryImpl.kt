package org.com.pharmacy.infrastructure.repository

import org.com.org.com.pharmacy.domain.model.Pharmacy
import org.com.pharmacy.domain.repository.PharmacyRepository
import org.com.pharmacy.infrastructure.repository.entities.PharmacyEntity
import org.com.pharmacy.infrastructure.repository.entities.toEntity
import org.com.pharmacy.infrastructure.repository.entities.toPharmacy
import org.springframework.stereotype.Repository

@Repository
class PharmacyRepositoryImpl(private val jpaRepository: JpaPharmacyRepository): PharmacyRepository {
    override fun findById(id: Long): Pharmacy? {
        return jpaRepository.findById(id)?.toPharmacy()
    }

    override fun addPharmacy(pharmacy: Pharmacy): Pharmacy {
        return jpaRepository.addPharmacy(pharmacy.toEntity()).toPharmacy()
    }
}