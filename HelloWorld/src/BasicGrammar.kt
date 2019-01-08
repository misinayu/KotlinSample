package sample

fun main(args: Array<String>) {
    // イミュターブルリスト
    val ints: List<Int> = listOf<Int>(1, 2, 3)
    println(ints)
    println(ints.size)
    println(ints[0])
    // error:: ints[0] = 5

    // MutableList（変更可能なリスト）
    val char: MutableList<Char> = mutableListOf('a', 'b')
    println(char)
    println(char[0])
    char[0] = 'c'
    println(char)

    char += 'X'
    println(char)
    char -= 'X'
    println(char)
    char.removeAt(0)
    println(char)
}