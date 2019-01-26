package sample

fun main(args: Array<String>) {

//    val bucket = object : Bucket {
//        // バケツの容量
//        val capacity: Int = 5
//
//        // 入っている水の量
//        var quantity: Int = 0
//
//        // バケツを水で満たす
//        fun fill() {
//            quantity = capacity
//        }
//
//        // 排水する
//        fun drainAway() {
//            quantity = 0
//        }
//
//        // 入っている水の量を出力する
//        fun printQuantity() {
//            println(quantity)
//        }
//
//        // 別のバケツに注ぐ
//        fun pourTo(that: Bucket) {
//            // TODO::
//        }
//    }

//    bucket.printQuantity()
//    bucket.fill()
//    bucket.printQuantity()
//    bucket.drainAway()
//    bucket.printQuantity()

    // 容量7のバケツをつくる
    val bucket1 = createBucket(7)

    // 容量4のバケツをつくる
    val bucket2 = createBucket(4)

    // バケツ1を満たす
    bucket1.fill()

    // バケツ1からバケツ2へ可能な限り注ぐ
    bucket1.pourTo(bucket2)

    println(bucket1.quantity) // 「３」を出力
    println(bucket2.quantity) // 「４」を出力
}


// インターフェイス
interface Bucket {
    fun fill()
    fun drainAway()
    fun pourTo(that: Bucket)

//    fun getCapacity(): Int
//    fun getQuantity(): Int
//    fun setQuantity(quantity: Int)

    val capacity: Int
    var quantity: Int
}

// バケツオブジェクトを得るための関数
fun createBucket(_capacity: Int): Bucket = object : Bucket {
//    var _quantity: Int = 0
    override val capacity = _capacity
    override var quantity: Int = 0


    override fun fill() {
        quantity = capacity
    }

    override fun drainAway() {
        quantity = 0
    }

    override fun pourTo(that: Bucket) {
        val thatVacuity = that.capacity - that.quantity
        if (capacity <= thatVacuity) {
            that.quantity += quantity
            drainAway()
        } else {
            that.fill()
            quantity -= thatVacuity
        }
    }
}