package org.com.pharmacy.domain.repository

import org.com.org.com.pharmacy.domain.model.Pharmacy

interface PharmacyRepository {
//    fun findAll(pageable: Pageable?): Page<Pharmacy?>?
    fun findById(id: Long): Pharmacy?
    fun addPharmacy(pharmacy: Pharmacy): Pharmacy
}