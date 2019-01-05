package sample

fun main(args: Array<String>) {
    val half = Rational(1, 2)
    println(half)
    val half2 = Rational(2, 5)
    println(half2)
}

class Rational(val numerator: Int, val denominator: Int) {
    override fun toString(): String = "${numerator}/${denominator}"
}