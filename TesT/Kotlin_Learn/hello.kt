package TesT.Kotlin_Learn

class Greeter(val name: String) {
    fun greet() {
        println("Hello,$name")
    }
}

fun main(args: Array<String>) {
    Greeter("Hello World")
    print(sum1(1, 2))
    sum2(1, 2)
    print(sum3(1, 2))
    println(sum4(1, 2))
    vars(2,1,45,4)
    lambda()

}

fun sum1(a: Int, b: Int): Int {
    return a + b
}

//Unit可以省略
fun sum2(a: Int, b: Int): Unit {
    print(a + b)
}

fun sum3(a: Int, b: Int) = a + b

// public 方法则必须明确写出返回类型
public fun sum4(a: Int, b: Int): Int = a + b

fun vars(vararg v:Int){
    for (vt in v){
        print(vt)
    }
}

fun lambda(){
    val sumLambda:(Int,Int)->(Int)={x,y->x+y}
    println(sumLambda(2,3))
}
fun declare(){
    //常量
    val constant1:Int=10
    //变量
    var variable2:String="v"
    //constant1=11
    variable2="vv"
}

/*
$ 表示一个变量名或者变量值

$varName 表示变量值

${varName.fun()} 表示变量的方法返回值
 */
fun zfc_model(){
    var a = 1
// 模板中的简单名称：
    val s1 = "a is $a"

    a = 2
// 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a"
}