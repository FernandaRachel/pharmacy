package org.com.org.com.pharmacy.aplication.service

import org.com.pharmacy.api.domain.model.Pharmacy
import org.com.pharmacy.domain.repository.PharmacyRepository
import org.springframework.stereotype.Component

@Component
class PharmacyService(private val repository: PharmacyRepository) {
    // TODO: add pharmacy input
    fun addPharmacy(): Pharmacy {
        return repository.addPharmacy(Pharmacy(1L, "Pharmacy 1"))
    }

    fun findPharmacyById(id: Long): Pharmacy? = repository.findById(id)
}