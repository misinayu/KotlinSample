package sample

fun main(args: Array<String>) {
//    val intContainer = Container(123)
//    val i: Int = intContainer.value as Int
//    println(i)
//
//    val strContainer = Container("Hello")
//    val s = strContainer.value as String
//    println(s)

    val intContainer: Container<Int> = Container<Int>(123)
    val i: Int = intContainer.value
    println(i)

    val strContainer = Container("Hello")
    println(strContainer.value.toUpperCase())
}

//class Container(var value: Any)
class Container<T>(var value: T)