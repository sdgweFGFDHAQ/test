package TesT.Kotlin_Learn

class Person {

    var lastName: String = "zhang"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set

//    var a: Int = 1
//        get()  { return field }
//        set(a) {
//            // FIXME: 2021/6/1
//            field = 2
//            this.a =3
//        }
var a: Int = 1
        get()=field
        set(b) {
            field = b+1
        }
}

// 测试
fun main(args: Array<String>) {
    var person: Person = Person()

    person.lastName = "wang"

    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")

    //??????????????????
    //println(person.a)
    //person.heiht=11.22f
    person.a=2
    println(person.a)
}