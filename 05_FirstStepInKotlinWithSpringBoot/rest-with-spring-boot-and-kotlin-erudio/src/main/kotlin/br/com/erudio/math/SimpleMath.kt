package br.com.erudio.math

import org.springframework.stereotype.Service
import kotlin.math.sqrt
@Service
class SimpleMath {

    fun sum(numberOne: Double, numberTwo: Double) = numberOne.plus(numberTwo)
    fun subtract(numberOne: Double, numberTwo: Double) = numberOne.minus(numberTwo)
    fun multiply(numberOne: Double, numberTwo: Double) = numberOne.times(numberTwo)
    fun divide(numberOne: Double, numberTwo: Double) = numberOne.div(numberTwo)
    fun avg(numberOne: Double, numberTwo: Double) = (numberOne.plus(numberTwo)) / 2
    fun square(number: Double) = sqrt(number)


}