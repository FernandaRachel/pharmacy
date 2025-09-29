package org.com.pharmacy.infrastructure.repository

import org.com.org.com.pharmacy.domain.model.Pharmacy
import org.com.pharmacy.infrastructure.repository.entities.PharmacyEntity
import org.springframework.data.repository.Repository

interface JpaPharmacyRepository: Repository<PharmacyEntity, Long> {
//    fun findAll(pageable: Pageable?): Page<Pharmacy?>?
    fun findById(id: Long): PharmacyEntity?
    fun addPharmacy(pharmacy: PharmacyEntity): PharmacyEntity
}