package sample

fun main(args: Array<String>) {
    // while文
    var count = 3
    while (count-- > 0) {
        println("Hello")
    }

    do {
        println("do while")
        val next = Math.random() < 0.5
    } while (next)
}