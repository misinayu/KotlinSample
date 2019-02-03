package sample

fun main(args: Array<String>) {

}

interface InterfaceGreeter {
    val language: String
    fun sayHello(target: String)
}

class EnglishGreeterInter : InterfaceGreeter {
    override val language = "English"
    override fun sayHello(target: String) {
        println("Hello, $target")
    }
}

open class Superclass

interface Foo
interface Bar

class MyInterClass: Superclass(), Foo, Bar