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

open class Superclass {
    open fun execute() {
        println("Superclass")
    }
}

interface Foo {
    fun execute()
}
interface Bar {
    fun execute()
}
interface Hoge {
    fun execute() {
        println("Hoge")
    }
}
interface Fuga {
    fun execute() {
        println("Fuga")
    }
}
interface Foo2 {
    fun aaa()
    fun bbb()
}
interface Bar2: Foo2 {
    override fun aaa() {}
    fun ccc()
}

class FooBar: Foo, Bar {
    override fun execute() {
        println("FooBar")
    }
}

class FooSubclass : Superclass(), Foo

class HogeFuga : Hoge, Fuga {
    override fun execute() {
        super<Fuga>.execute()
    }
}

class Baz: Bar2 {
    override fun bbb() {}
    override fun ccc() {}
}