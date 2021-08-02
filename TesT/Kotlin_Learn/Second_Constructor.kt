package TesT.Kotlin_Learn

class baidu  constructor(name: String) {  // 类名为 baidu
    // 大括号内是类体构成
    var url: String = "http://www.baidu.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }
    // 次构造函数
    constructor (name: String, alexa: Int) : this(name) {
        println("Alexa 排名 $alexa")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

fun main(args: Array<String>) {
    val baidu =  baidu("百度", 10000)
    println(baidu.siteName)
    println(baidu.url)
    println(baidu.country)
    baidu.printTest()
}