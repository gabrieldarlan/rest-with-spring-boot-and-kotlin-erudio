package br.com.erudio.utils

import br.com.erudio.converter.Converter
import br.com.erudio.exceptions.UnsupportedMathOperationException

object Validation {
    fun isNumeric(numberOne: String?, numberTwo: String?) {
        if (!Converter.isNumeric(numberOne) || !Converter.isNumeric(numberTwo)) throw UnsupportedMathOperationException(
            "Please set a numeric value!"
        )
    }

    fun isGreaterZeros(numberOne: Double, numberTwo: Double) {
        if (numberOne <= 0.0 || numberTwo <= 0.0) throw UnsupportedMathOperationException(
            "Number must be greater than zero."
        )
    }

}