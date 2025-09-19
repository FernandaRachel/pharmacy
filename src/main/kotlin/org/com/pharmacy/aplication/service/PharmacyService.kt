package org.com.org.com.pharmacy.aplication.service

import org.com.org.com.pharmacy.api.controller.model.PharmacyRequest
import org.com.pharmacy.api.domain.model.Pharmacy
import org.com.pharmacy.domain.repository.PharmacyRepository
import org.springframework.stereotype.Component

@Component
class PharmacyService(private val repository: PharmacyRepository) {
    // TODO: add pharmacy input
    fun addPharmacy(request: Pharmacy): Pharmacy {
        return repository.addPharmacy(request)
    }

    fun findPharmacyById(id: Long): Pharmacy? = repository.findById(id)
}