package sample

fun main(args: Array<String>) {
    // 配列
    val ints = arrayOfNulls<Int>(5)
    println(ints.size)
    println(ints[0])
    ints[0] = 123
    println(ints[0])

    val strs = arrayOf("red", "green", "blue")
    println(strs[0])
}