package sample

fun main(args: Array<String>) {
    val half = Rational(55, 100)
    println(half)
    val half2 = Rational(2, 6)
    println(half2)
}

class Rational(val numerator: Int, val denominator: Int) {
    init {
        require(denominator != 0, {"denominator must not be null"})
    }

    private val g = gcd(Math.abs(numerator), Math.abs(denominator))
    val n: Int = numerator / g
    val d: Int = denominator / g
    override fun toString(): String = "${n}/${d}"

    tailrec private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a
        else gcd(b, a % b)
}