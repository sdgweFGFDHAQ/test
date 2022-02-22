package TesT.Kotlin_Learn

fun if_when() {

    //System.out.println(3>2?"a":"b");
    //remove(),poll(),take()
    println(if (3 > 2) "a" else "b")

    val v = arrayOf(6, 2, 5)
    val vv = if (v[1] > v[0]) {
        v[0]
    } else {
        v[2]
    }
    println(vv)

    val vl = arrayOf(6, 2, 5)
    val vl1=vl.reverse()
    if (vl[1] > vl[0]) {
        vl[1] = vl[0]
    } else {
        vl[1] = vl[2]
    }
    println("${vl[1]}")
    println("反转${vl1}")

    val x = 10
    if (x in 0..11) {
        println("..")
    } else if (x in 2 until 10 step 2) {
        println("until/step")
    } else if (x in 10 downTo 2 step 2) {
        println("downTo/step")
    }

    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }
    when (x) {
        in 1..10 -> print("x is in the range")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
}

fun while_dowhile() {
    println("----while 使用-----")
    var x = 0
    while (x > 0) {
        println(x--)
    }
    println("----do...while 使用-----")
    var y = 0
    do {
        println(y--)
    } while (y > 0)
}

fun continue_break() {
    for (i in 1..10) {
        if (i == 3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        println(i)
        if (i > 5) break   // i 为 6 时 跳出循环
    }
}

fun label() {
    loopi@ for (i in 1..10) {
        loopj@ for (j in 1..10) {
            println(i + j)
            if (j == 5) break@loopj
            if (i == 3 && j == 4) break@loopi
        }
    }
}

fun return_label() {
    val ints = arrayOf(0, 1, 2, 3, 4, 5)

    fun foo() {
        ints.forEach {
            if (it == 2) return
            print(it)
        }
    }

    fun foo0() {
        ints.forEach lit@{
            if (it == 2) return@lit
            print(it)
        }
    }

    /*当要返一个回值的时候，解析器优先选用标签限制的 return，即

    return@a 1
    意为"从标签 @a 返回 1"，而不是"返回一个标签标注的表达式 (@a 1)"。
     */
    fun foo1() {
        ints.forEach {
            if (it == 0) return@forEach
            print(it)
        }
    }

    fun foo2() {
        ints.forEach(fun(value: Int) {
            if (value == 0) return
            print(value)
        })
    }
}

fun main() {
//    if_when()
//    while_dowhile()
//    continue_break()
//    label()
    return_label()
}
