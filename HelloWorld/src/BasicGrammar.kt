package sample

fun main(args: Array<String>) {
    // if文
    val score = 75
    val grade =
        if (score >= 90) 'A'
        else if (score >= 80) 'B'
        else if (score >= 70) 'C'
        else if (score >= 60) 'D'
        else 'F'
    println(grade)
}