package sample

import java.util.concurrent.atomic.LongAccumulator

fun main(args: Array<String>) {
    println(succ(32))
//    println(sum(arrayOf(1, 2, 3)))
    println(sub(5, 3))
    println(hello())
    println(hello("Alice"))
//    println(sum(1, 2, 3))
//    println(sum(*intArrayOf(1, 2, 3)))
//    val ints = intArrayOf(2, 3, 4)
//    println(sum(*ints))
    println(sum((1L..123456).toList()))
}

fun succ(i: Int): Int = i + 1

//fun sum(vararg ints: Array<Int>): Int {
//    var sum = 0
//    for (i in ints) {
//        sum += i
//    }
//    return sum
//}

fun sub(minuend: Int, subtrahend: Int): Int =
        minuend - subtrahend

fun hello(name: String = "World"): String = "Hello, $name!"

//fun sum(vararg ints: Int): Int {
//    var sum = 0
//    for (i in ints) {
//        sum += i
//    }
//    return sum
//}

fun sum(numbers: List<Long>): Long {
    tailrec fun go(numbers: List<Long>, accumulator: Long): Long =
        if (numbers.isEmpty()) accumulator
        else go(numbers.drop(1), accumulator + numbers.first())
    return go(numbers, 0)
}