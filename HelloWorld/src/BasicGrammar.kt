package sample

fun main(args: Array<String>) {
    // ミュターブルMap
    val numberMap: MutableMap<String, Int> =
            mutableMapOf("one" to 1, "two" to 2)
    println(numberMap)
    println(numberMap.size)
    println(numberMap["one"])
    println(numberMap["three"])
    numberMap += "three" to 3
    println(numberMap["three"])
}