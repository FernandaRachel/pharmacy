package org.com.pharmacy.api.controller.dto

import org.com.pharmacy.api.domain.model.Pharmacy

data class PharmacyResponse(val id: Long, val name: String) {
    fun toResponse(pharmacy: Pharmacy): PharmacyResponse {
        return PharmacyResponse(id = pharmacy.id, name = pharmacy.name)
    }
}