package sample

fun main(args: Array<String>) {
    val half = Rational(55, 100)
    println(half)
    val half2 = Rational(2, 6)
    println(half2)
    println(Rational(1, 4) + Rational(1, 2))
    println(Rational(1, 3) + Rational(4, 7))
}

class Rational(val numerator: Int, val denominator: Int) {
    init {
        require(denominator != 0, {"denominator must not be null"})
    }

    private val g by lazy { gcd(Math.abs(numerator), Math.abs(denominator)) }
    val n: Int by lazy { numerator / g }
    val d: Int by lazy { denominator / g }
    // funの前にoperatorを付けるとmethod.plusだけでなく+記号で使えるようになる
    operator fun plus(that: Rational): Rational =
        Rational(
            n * that.denominator + that.numerator * d,
            d * that.denominator
        )

    override fun toString(): String = "${n}/${d}"

    tailrec private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a
        else gcd(b, a % b)
}