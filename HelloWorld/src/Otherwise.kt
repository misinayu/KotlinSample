package sampleOtherwise

fun main(args: Array<String>) {
    val product = MyInt(3) * MyInt(5)
    println(product.value)
    println((MyInt(20) % MyInt(3)).value)

    val service = Service();
    println(service())
    println(service('B'))
    println(service.invoke('C'))

    println(MyInt(2) == MyInt(2))
    println(MyInt(1) == MyInt(3))
    println(MyInt(1) != MyInt(3))

    // 分解宣言
    val (a, b, c) = object {
        operator fun component1(): String = "Hello"
        operator fun component2(): Int = 123
        operator fun component3(): List<Char> = listOf('A', 'B')
    }
    println(a)
    println(b)
    println(c)
}

// 演算子オーバーロード
class MyInt(val value: Int) {
    operator fun times(that: MyInt): MyInt =
            MyInt(value * that.value)

    operator fun rem(that: MyInt): MyInt =
            MyInt(value % that.value)

    override fun equals(other: Any?): Boolean =
            if (other is MyInt) value == other.value
            else false
}

class Service {
    operator fun invoke(): Char = 'A'
    operator fun invoke(c: Char) = c
}