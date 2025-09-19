package org.com.org.com.pharmacy.api.controller.model

import org.com.pharmacy.api.controller.dto.PharmacyResponse
import org.com.pharmacy.api.domain.model.Pharmacy

data class PharmacyRequest(
    val name: String,
    val address: String,
    val country: String,
    val city: String
) {
    fun toResponse(pharmacy: Pharmacy): PharmacyResponse {
        return PharmacyResponse(id = pharmacy.id, name = pharmacy.name)
    }
}
