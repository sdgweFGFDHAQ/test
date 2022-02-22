//package TesT.Kotlin_Learn
//
//import org.junit.Test
//
////非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性：
//public class MyTest {
//    class TestSubject {
//        fun method() {
//            TODO("Not yet implemented")
//        }
//
//        class T constructor(int: Int) {}
//    }
//
//    lateinit var subject: TestSubject
//
//    @Setup
//    fun setup() {
//        subject = TestSubject()
//    }
//
//    annotation class Setup
//
//    @Test
//    fun test() {
//        subject.method()  // dereference directly
//    }
//}
//
//
////类、方法等默认为final，
////open关键字使得类可以被继承、方法可以被重载
//open class Base {
//    open fun f() {}
//}
////抽象类
//abstract class Derived : Base() {
//    override abstract fun f()
//}
