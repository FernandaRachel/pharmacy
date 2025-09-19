package org.com.pharmacy.api.controller.dto

import org.com.pharmacy.api.domain.model.Pharmacy

data class PharmacyResponse(
    val id: Long,
    val name: String,
    val address: String,
    val country: String,
    val city: String
) {
    fun toResponse(pharmacy: Pharmacy): PharmacyResponse {
        return PharmacyResponse(
            id = pharmacy.id!!,
            name = pharmacy.name,
            address = address,
            country = country,
            city = city
        )
    }
}