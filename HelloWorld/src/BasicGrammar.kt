package sample

fun main(args: Array<String>) {
    // イミュターブルセット
    val ints: Set<Int> = setOf(1, 2, 1, 3)
    println(ints)
    // ミュータブルセット
    val chars: MutableSet<Char> = mutableSetOf('a', 'a', 'b')
    // Setは要素の重複がない
    println(chars)
    chars -= 'a'
    println(chars)
}