package sample

fun main(args: Array<String>) {
    // forループ
    for (x in arrayOf(1, 2, 3)) {
        println(x)
    }

    val names = listOf("foo", "bar", "bax")
    for (name in names) {
        println(name)
    }

    for (i in 1..10 step 2) {
        println(i)
    }

    // Iterator
    for (item in MyIterable()) {
        println(item)
    }

    // break
    var barIndex = -1
    for (index in names.indices) {
        if (names[index] == "bar") {
            barIndex = index
            println(barIndex)
            break

        }
    }

    // label
    println("label----------------------")
    loop@ for (x in 1..10) {
        for (y in 1..10) {
            println(x + y)
            if (y == 5) {
                break@loop
            }
        }
    }
}

class MyIterator {
    operator fun hasNext(): Boolean = Math.random() < 0.5
    operator fun next(): String = "Hello"
}

class MyIterable {
    operator fun iterator() = MyIterator()
}