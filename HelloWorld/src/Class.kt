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
    println(hanako.nameLength)

    val half = Rational1(1, 2)
    println(half.numerator)
    println(half.denominator)

    val five = Rational1(5)
    println(five.numerator)
    println(five.denominator)
}

class MyClass {
    lateinit var foo: String
}

class Greeter {
    fun greet(name: String) {
        println("Hello, $name")
    }
}

class Person {
    // custom setter
    var name: String = ""
        set(value) {
            println("${value}がセットされました")
            field = value
        }
    var age: Int = 0
    // custom getter
    val nameLength: Int
        get(): Int {
            return this.name.length
        }
}

// constructor
//class Rational1 constructor(n: Int, d: Int) {
//    val numerator: Int = n
//    val denominator: Int = d
//}
class Rational1(val numerator: Int, val denominator: Int) {
    constructor(numerator: Int): this(numerator, 1)
}