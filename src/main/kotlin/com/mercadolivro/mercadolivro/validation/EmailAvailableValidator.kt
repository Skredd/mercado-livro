package com.mercadolivro.mercadolivro.validation

import com.mercadolivro.mercadolivro.service.CustomerService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailAvailableValidator(
    val customerService: CustomerService
) : ConstraintValidator<EmailAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return true
        }

        return customerService.emailAvailable(value)
    }

}
