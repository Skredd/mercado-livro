package com.mercadolivro.mercadolivro.events.listener

import com.mercadolivro.mercadolivro.events.PurchaseEvent
import com.mercadolivro.mercadolivro.model.PurchaseModel
import com.mercadolivro.mercadolivro.service.BookService
import com.mercadolivro.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @EventListener
    fun generateNfe(purchaseEvent: PurchaseEvent) {
        println("Atualizando o status dos livros")
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}