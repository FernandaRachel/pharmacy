package org.com.pharmacy.api.controller

import jakarta.validation.Valid
import org.com.org.com.pharmacy.api.controller.model.PharmacyRequest
import org.com.org.com.pharmacy.aplication.service.PharmacyService
import org.com.pharmacy.api.controller.dto.PharmacyResponse
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@SpringBootApplication
@RestController
open class PharmacyController(private val pharmacyService: PharmacyService) {

    @GetMapping("/pharmacy")
    fun getPharmacy(@RequestParam(value = "id") id: Long): ResponseEntity<PharmacyResponse> {
        // TODO: id non null id validation
        val foundPharmacy = pharmacyService.findPharmacyById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(foundPharmacy.toResponse())
    }

    @PostMapping("/pharmacy")
    fun postPharmacy(@RequestBody @Valid request: PharmacyRequest): ResponseEntity<PharmacyResponse> {
        val addedPharmacy = pharmacyService.addPharmacy(request.toPharmacy())
        return ResponseEntity.ok(addedPharmacy.toResponse())
    }
}

