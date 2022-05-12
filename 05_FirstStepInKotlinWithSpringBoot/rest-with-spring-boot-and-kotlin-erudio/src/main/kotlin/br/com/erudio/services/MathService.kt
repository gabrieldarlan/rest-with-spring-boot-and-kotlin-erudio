package br.com.erudio.services

import br.com.erudio.converter.Converter.convertToDouble
import br.com.erudio.converter.Converter.isNumeric
import br.com.erudio.exceptions.UnsupportedMathOperationException
import br.com.erudio.math.SimpleMath
import br.com.erudio.utils.Validation.isGreaterZeros
import br.com.erudio.utils.Validation.isNumeric
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MathService(
    @Autowired
    private val simpleMath: SimpleMath
) {
    fun sum(numberOne: String?, numberTwo: String?): Double {
        return isNumeric(numberOne, numberTwo).let {
            simpleMath.sum(convertToDouble(numberOne), convertToDouble(numberTwo))
        }
    }

    fun subtraction(numberOne: String?, numberTwo: String?): Double {
        return isNumeric(numberOne, numberTwo).let {
            simpleMath.subtract(convertToDouble(numberOne), convertToDouble(numberTwo))
        }
    }

    fun multiply(numberOne: String?, numberTwo: String?): Double {
        return isNumeric(numberOne, numberTwo).let {
            simpleMath.multiply(convertToDouble(numberOne), convertToDouble(numberTwo))
        }

    }

    fun division(numberOne: String?, numberTwo: String?): Double {
        return isNumeric(numberOne, numberTwo).run {
            isGreaterZeros(convertToDouble(numberOne), convertToDouble(numberTwo))
        }.let {
            simpleMath.divide(convertToDouble(numberOne), convertToDouble(numberTwo))
        }
    }

    fun avg(numberOne: String?, numberTwo: String?): Double {
        return isNumeric(numberOne, numberTwo).let {
            simpleMath.avg(convertToDouble(numberOne), convertToDouble(numberTwo))
        }
    }

    fun square(number: String?): Double {
        if (!isNumeric(number)) throw UnsupportedMathOperationException("Please set a numeric value!")
        return simpleMath.square(convertToDouble(number))

    }
}