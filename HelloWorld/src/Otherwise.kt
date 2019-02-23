package sampleOtherwise

import java.lang.Exception

fun main(args: Array<String>) {
    val product = MyInt(3) * MyInt(5)
    println(product.value)
    println((MyInt(20) % MyInt(3)).value)

    val service = Service();
    println(service())
    println(service('B'))
    println(service.invoke('C'))

    println(MyInt(2) == MyInt(2))
    println(MyInt(1) == MyInt(3))
    println(MyInt(1) != MyInt(3))

    // 分解宣言
    val (a, b, c) = object {
        operator fun component1(): String = "Hello"
        operator fun component2(): Int = 123
        operator fun component3(): List<Char> = listOf('A', 'B')
    }
    println(a)
    println(b)
    println(c)

    // データクラス
    println(User(1, "Taro") == User(1, "Taro"))
    println(User(2, "Hanako"))

    val taro = User(1, "Taro")
    println(taro)
    val newTaro = taro.copy(id=112233)
    println(newTaro)
    println(taro)

    val (id, name) = User(7, "hego")
    println(id)
    println(name)

    // ネストしたクラス
    val id2: User2.Id = User2.Id(123)
    println(User2(id2, "test"))

    // オブジェクト式
    val myObject = object {}
    println(myObject)

    val greeter = object {
        fun greet() {
            println("Hello Greet")
        }
    }
    greeter.greet()

    val greeter2 = object : Greeter2 {
        override fun greet() {
            println("Hello Greeter2")
        }
    }
    greeter2.greet()

    // オブジェクト宣言
    JapaneseGreeter.greet("たろう")
    val greeterde: JapaneseGreeter = JapaneseGreeter
    greeterde.greet("じろう")

    // コンパニオンオブジェクト
    val dummy = Usercom.Pool.DUMMY
    println("${dummy.id}, ${dummy.name}")
    println(Usercom.DUMMY.name)

    // 代数的データ型
    println(Cons("foo", Cons("bar", Cons("baz", Nil))))

    println(headString(Cons("foo", Nil)))
    println(headString(Nil))

    // 例外
//    throw MyException("例外だよ")
    try {
        println("try")
    } catch (e: Exception) {
        println("catch")
    } finally {
        println("finally")
    }

    println(try {
        "ONE".toInt()
    } catch (e: Exception) {
        null
    } finally {
        println("finally")
    })

    // メソッドの関数オブジェクト
    println(5.inc())
    val method = Int::inc
    println(method)
}

// 演算子オーバーロード
class MyInt(val value: Int) {
    operator fun times(that: MyInt): MyInt =
            MyInt(value * that.value)

    operator fun rem(that: MyInt): MyInt =
            MyInt(value % that.value)

    override fun equals(other: Any?): Boolean =
            if (other is MyInt) value == other.value
            else false
}

class Service {
    operator fun invoke(): Char = 'A'
    operator fun invoke(c: Char) = c
}

data class User(val id: Long, val name: String)

data class User2(val id: Id, val name: String) {
    data class Id(val value: Long)
}

interface Greeter2 {
    fun greet()
}

interface Greeterde {
    fun greet(name: String)
}

object JapaneseGreeter: Greeterde {
    override fun greet(name: String) {
        println("こんにちは、${name}さん！")
    }
}

class Usercom(val id: Long, val name: String) {
    companion object Pool{
        val DUMMY = Usercom(0, "dummy")
    }
}

interface MyList<out T>

object Nil: MyList<Nothing> {
    override fun toString(): String = "Nil"
}

class Cons<T>(val head: T, val tail: MyList<T>): MyList<T> {
    override fun toString(): String = "$head:$tail"
}

fun headString(list: MyList<*>): String =
        when (list) {
            is Cons<*> -> list.head.toString()
            else -> "要素なし"
        }

class MyException(message: String): Exception(message)