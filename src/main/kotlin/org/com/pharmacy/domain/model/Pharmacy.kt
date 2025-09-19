package org.com.pharmacy.api.domain.model

import org.com.pharmacy.api.controller.dto.PharmacyResponse

data class Pharmacy(val id: Long, val name: String) {
    fun toResponse(): PharmacyResponse = PharmacyResponse(id, name)
}