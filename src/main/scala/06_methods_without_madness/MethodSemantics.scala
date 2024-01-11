import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object MethodSemantics extends App {
    // def example(a: => Int, b: => Int): Int = {
    //     println("In the method body!")

    //     print(a + b)

    //     a + b
    // }

    def example(a: Int, b: Int): Int = {
        println("In the method body!")

        a + b
    }

    example({ println("a"); 1 }, { println("b"); 2 })

    // println(example({ println("a"); 1 }, { println("b"); 2 }))
}
