package sample

fun main(args: Array<String>) {
    val person: Person1 = Person1("ゆたか")
    person.introduceMyself()

    val student: Student = Student("くみこ", 123)
    println(student.id)
    println(student.name)
    student.introduceMyself()
}

open class Person1(val name: String) {
    fun introduceMyself() {
        println("I am $name.")
    }
}

class Student(name: String, val id: Long): Person1(name)