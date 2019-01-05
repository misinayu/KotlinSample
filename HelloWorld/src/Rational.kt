package sample

fun main(args: Array<String>) {
    val half = Rational(1, 2)
    println(half)
    println(half.denominator)
}

class Rational(val numerator: Int, val denominator: Int)