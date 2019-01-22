package sample

fun main(args: Array<String>) {
    val functionObject = ::square
    println(functionObject(5))
    println(firstK2("kakakakKwowKKow"))
    println(firstUpperCase2("niniCoCo"))
    // lambda expression
    val squareR: (Int) -> Int = { i: Int ->
        i * i
    }
    // 型推論で型を省略できる
    val squareR1 = { i: Int ->
        i * i
    }
    val squareR2: (Int) -> Int = { i ->
        i * i
    }
    // 引数が唯一の場合it変数が使える
    val squareR3: (Int) -> Int = {
        it * it
    }
    println(squareR(6))
    println(firstWhitespace("str stet"))
    val counter1 = getCounter()
    val counter2 = getCounter()
    println("-----------closure-------------")
    println(counter1())
    println(counter1())
    println(counter2())
    println(counter1())
    println(counter2())
    println("-----------closure-------------")
}

fun square(i: Int): Int = i * i

fun firstK(str: String): Int {
    tailrec fun go(str: String, index: Int): Int =
            when {
                str.isEmpty() -> -1
                str.first() == 'K' -> index
                else -> go(str.drop(1), index + 1)
            }
    return go(str, 0)
}

fun firstUpperCase(str: String): Int {
    tailrec fun go(str: String, index: Int): Int =
            when {
                str.isEmpty() -> -1
                str.first().isUpperCase() -> index
                else -> go(str.drop(1), index + 1)
            }
    return go(str, 0)
}

// firstK() と firstUpperCase() を共通化した関数
fun first(str: String, predicate: (Char) -> Boolean): Int {
    tailrec fun go(str: String, index: Int): Int =
            when {
                str.isEmpty() -> -1
                predicate(str.first()) -> index
                else -> go(str.drop(1), index + 1)
            }
    return go(str, 0)
}

fun firstK2(str: String): Int {
    fun  isK(c: Char): Boolean = c == 'K'
    return first(str, ::isK)
}

fun firstUpperCase2(str: String): Int {
    fun isUpperCase(c: Char): Boolean = c.isUpperCase()
    return first(str, ::isUpperCase)
}

//fun firstWhitespace(str: String): Int {
//    val isWhitespace: (Char) -> Boolean = {
//        it.isWhitespace()
//    }
//    return first(str, isWhitespace)
//}
fun firstWhitespace(str: String): Int =
        first(str, { it.isWhitespace() })
fun firstWhitespace2(str: String): Int =
        first(str) { it.isWhitespace() }

// Closure
fun getCounter(): ()->Int {
    var count = 0
    return {
        count++
    }
}