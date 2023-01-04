package com.mercadolivro.mercadolivro.events.listener

import com.mercadolivro.mercadolivro.events.PurchaseEvent
import com.mercadolivro.mercadolivro.model.PurchaseModel
import com.mercadolivro.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateNfeListener(
    private val purchaseService: PurchaseService
) {

    @EventListener
    fun generateNfe(purchaseEvent: PurchaseEvent) {
        println("Gerando NFE")

        val nfe = UUID.randomUUID().toString()
        val purchaseModel = purchaseEvent.purchaseModel.copy(nfe = nfe)

        purchaseService.update(purchaseModel)
    }
}