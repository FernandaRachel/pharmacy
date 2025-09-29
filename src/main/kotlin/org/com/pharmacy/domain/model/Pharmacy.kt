package org.com.org.com.pharmacy.domain.model

import org.com.pharmacy.api.controller.dto.PharmacyResponse

data class Pharmacy(val id: Long?,
                    val name: String,
                    val address: String,
                    val country: String,
                    val city: String) {
    fun toResponse(): PharmacyResponse = PharmacyResponse(id!!, name, address, country, city)
}