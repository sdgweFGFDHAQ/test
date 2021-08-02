package TesT.Kotlin_Learn

fun main() {
    val text = """
        |zs1
        |zs12
        |zs123
    """.trimMargin()
    println(text)

    val text2 = """
        $9.99
    """.trimIndent()
    println(text2)
    println("${'$'}9.99")

    //[1,2,3]
    val a = arrayOf(1, 2, 3)
    //[0,2,4]
    val ba = Array(3, { i -> i })
    val b = Array(3, { i -> (i * 2) })

    //读取数组内容
    println(a[0])    // 输出结果：1
    println(ba)
    println(b[1])    // 输出结果：2
}