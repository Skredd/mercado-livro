package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.controller.mapper.PurchaseMapper
import com.mercadolivro.mercadolivro.controller.request.PostPurchaseRequest
import com.mercadolivro.mercadolivro.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/purchase")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPurchase(@RequestBody purchase: PostPurchaseRequest) {
        purchaseService.create(purchaseMapper.toModel(purchase))
    }
}