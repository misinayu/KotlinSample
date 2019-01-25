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

    println(bucket1.getQuantity()) // 「３」を出力
    println(bucket2.getQuantity()) // 「４」を出力
}


// インターフェイス
interface Bucket {
    fun fill()
    fun drainAway()
    fun pourTo(that: Bucket)

    fun getCapacity(): Int
    fun getQuantity(): Int
    fun setQuantity(quantity: Int)
}

// バケツオブジェクトを得るための関数
fun createBucket(capacity: Int): Bucket = object : Bucket {
    var _quantity: Int = 0

    override fun fill() {
        setQuantity(getCapacity())
    }

    override fun drainAway() {
        setQuantity(0)
    }

    override fun pourTo(that: Bucket) {
        val thatVacuity = that.getCapacity() - that.getQuantity()
        if (getQuantity() <= thatVacuity) {
            that.setQuantity(that.getQuantity() + getQuantity())
            drainAway()
        } else {
            that.fill()
            setQuantity(getQuantity() - thatVacuity)
        }
    }

    override fun getCapacity(): Int = capacity

    override fun getQuantity(): Int = _quantity

    override fun setQuantity(quantity: Int) {
        _quantity = quantity
    }
}