package sampleOtherwise

fun main(args: Array<String>) {
    val product = MyInt(3) * MyInt(5)
    println(product.value)
    println((MyInt(20) % MyInt(3)).value)

    val service = Service();
    println(service())
    println(service('B'))
    println(service.invoke('C'))
}

class MyInt(val value: Int) {
    operator fun times(that: MyInt): MyInt =
            MyInt(value * that.value)

    operator fun rem(that: MyInt): MyInt =
            MyInt(value % that.value)
}

class Service {
    operator fun invoke(): Char = 'A'
    operator fun invoke(c: Char) = c
}