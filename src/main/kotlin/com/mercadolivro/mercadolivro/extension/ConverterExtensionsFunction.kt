package com.mercadolivro.mercadolivro.extension

import com.mercadolivro.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.mercadolivro.controller.response.BookResponse
import com.mercadolivro.mercadolivro.controller.response.CustomerResponse
import com.mercadolivro.mercadolivro.enums.BookStatus
import com.mercadolivro.mercadolivro.enums.CustomerStatus
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email!!,
        status = CustomerStatus.ATIVO
    )
}

fun PostCustomerRequest.toCustomerModel(customer: CustomerModel): CustomerModel {
    return CustomerModel(
        id = customer.id, name = this.name,
        email = this.email!!,
        status = customer.status
    )
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        email = this.email ?: previousValue.email,
        status = this.status ?: previousValue.status
    )
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name!!,
        price = this.price!!,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}