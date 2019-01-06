package sample

fun main(args: Array<String>) {
    val half = Rational(1, 0)
    println(half)
    val half2 = Rational(2, 5)
    println(half2)
}

class Rational(val numerator: Int, val denominator: Int) {
    init {
        require(denominator != 0, {"denominator must not be null"})
    }
    override fun toString(): String = "${numerator}/${denominator}"
}