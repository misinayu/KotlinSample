package sample

fun main(args: Array<String>) {
    val person: Person1 = Person1("ゆたか")
    person.introduceMyself()

    val student: Student = Student("くみこ", 123)
    println(student.id)
    println(student.name)
    student.introduceMyself()

    EnglishGreeter("Kotlin").sayHello()

    JapaneseGreeter("Java").sayHello()
}

open class Person1(open val name: String) {
    open fun introduceMyself() {
        println("I am $name.")
    }
}

class Student(override val name: String, val id: Long): Person1(name) {
    override fun introduceMyself() {
        super.introduceMyself()
        println("I am $name(id=$id)")
    }
}

abstract class AbstractGreeter(val target: String) {
    abstract fun sayHello()
}

class EnglishGreeter(target: String) : AbstractGreeter(target) {
    override fun sayHello() {
        println("Hello, $target!")
    }
}

class JapaneseGreeter(target: String) : AbstractGreeter(target) {
    override fun sayHello() {
        println("こんにちは、$target！")
    }
}