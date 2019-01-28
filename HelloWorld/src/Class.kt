package sample

fun main(args: Array<String>) {
    val myClass: MyClass = MyClass()
    println(myClass)

    val greeter = Greeter()
    greeter.greet("Kotlin")
}

class MyClass

class Greeter {
    fun greet(name: String) {
        println("Hello, $name")
    }
}