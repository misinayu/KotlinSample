package sample

import java.lang.AssertionError

fun main(args: Array<String>) {
    val s: String? = null
    println(s)

    val a: String? = null
    val b: String? = "Hello"

    if (a != null) {
        println(a.toUpperCase())
    }
    if (b != null) {
        println(b.toUpperCase())
    }

    val list: List<Any> = listOf(1, 'a', false)
    for(e in list) {
        val result: Any? = when (e) {
            is Int -> e + 5
            is Char -> e.toUpperCase()
            is Boolean -> e.not()
            else -> null
        }
        println(result)
    }

    val ain: Int? = 5
    val aInc: Int? = ain?.inc()

    fun squaregene(i: Int): Int = i * i
    val asqu: Int? = 5
    val aSquare =
        if (asqu != null) squaregene(asqu)
        else null
    println(aSquare)

    val aSquare2 = asqu?.let { squaregene(it) }
    println(aSquare2)

    val foogene2: String? = "simple test"
    val bargene2: String = foogene2!!
    println(bargene2.toUpperCase())

    // エルビス演算子
    val fooel: String? = "elelelelelelel"
    println((fooel ?: "default").toUpperCase())

    val hogeel: String? = null
    println(hogeel ?: "default")

    val fooerr: String? = "HelloErr"
    println(fooerr ?: throw AssertionError())

    val hogeerr: String? = null
    println(hogeerr ?: throw AssertionError())
}

public inline fun <T, R> T.let(block: (T) -> R): R = block(this)