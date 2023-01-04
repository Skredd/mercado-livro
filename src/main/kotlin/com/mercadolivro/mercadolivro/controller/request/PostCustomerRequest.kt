package com.mercadolivro.mercadolivro.controller.request

import com.mercadolivro.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,

    @EmailAvailable
    @field:Email(message = "E-mail deve ser valido")
    @field:NotEmpty(message = "Email deve ser informado")
    var email: String?
)