package sample

fun main(args: Array<String>) {
    val myClass: MyClass = MyClass()
    println(myClass)

    val greeter = Greeter()
    greeter.greet("Kotlin")

    val hanako = Person()

    println(hanako.name)
    println(hanako.age)

    hanako.name = "はなこ"
    hanako.age = 25

    println(hanako.name)
    println(hanako.age)
}

class MyClass

class Greeter {
    fun greet(name: String) {
        println("Hello, $name")
    }
}

class Person {
    var name: String = ""
    var age: Int = 0
}