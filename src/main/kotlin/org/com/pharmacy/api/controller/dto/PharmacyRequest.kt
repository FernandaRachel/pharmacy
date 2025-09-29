package org.com.org.com.pharmacy.api.controller.model

import org.com.org.com.pharmacy.domain.model.Pharmacy

data class PharmacyRequest(
    val name: String,
    val address: String,
    val country: String,
    val city: String
) {
    fun toPharmacy(): Pharmacy {
        return Pharmacy(
            id = null,
            name = this.name,
            address = this.address,
            country = this.country,
            city = this.city,
        )
    }
}
