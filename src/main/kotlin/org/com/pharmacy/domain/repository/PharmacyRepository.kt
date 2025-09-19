package org.com.pharmacy.domain.repository

import org.com.org.com.pharmacy.api.controller.model.PharmacyRequest
import org.com.pharmacy.api.domain.model.Pharmacy
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.Repository

interface PharmacyRepository: Repository<Pharmacy, Long> {
    fun findAll(pageable: Pageable?): Page<Pharmacy?>?
    fun findById(id: Long): Pharmacy?
    fun addPharmacy(pharmacy: Pharmacy): Pharmacy
}