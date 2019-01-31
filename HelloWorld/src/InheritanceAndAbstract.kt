package sample

fun main(args: Array<String>) {
    val person: Person1 = Person1("ゆたか")
    person.introduceMyself()

    val student: Student = Student("くみこ", 123)
    println(student.id)
    println(student.name)
    student.introduceMyself()
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