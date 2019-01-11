package sample

fun main(args: Array<String>) {
    // when式
    // Javaにおけるswitch文を強力にしたようなもの
    val x = 22
    val result = when (x) {
        1 -> "one"
        2, 3 -> "two or three"
        else -> {
            "unknown"
        }
    }
    println(result)

    // 分岐条件の部分に、定数以外を指定できる
    val result2 = when (x) {
        1 -> "one"
        myFavoriteInt() -> "favorite: $x"
        in 2..10 -> "1 <= x <= 10"
        else -> x.toString()
    }
    println(result2)

    // 型チェックで分岐
    val msg = "test"
    val blank = when (msg) {
        is String -> msg.isBlank()
        else -> true
    }
    println(blank)

    val score = 69
    val scorere = when {
        score >= 90 -> 'A'
        score >= 80 -> 'B'
        score >= 70 -> 'C'
        score >= 60 -> 'D'
        else ->'F'
    }
    println(scorere)
}

fun myFavoriteInt(): Int {
    return 22
}