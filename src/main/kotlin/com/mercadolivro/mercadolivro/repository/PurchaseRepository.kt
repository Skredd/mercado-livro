package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.model.PurchaseModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PurchaseRepository : CrudRepository<PurchaseModel, Long> {

}
