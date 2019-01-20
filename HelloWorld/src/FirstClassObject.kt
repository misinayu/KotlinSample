package sample

fun main(args: Array<String>) {
    val functionObject = ::square
    println(functionObject(5))
}

fun square(i: Int): Int = i * i