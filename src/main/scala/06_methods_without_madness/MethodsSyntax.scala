import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object MethodsSyntax extends App {
    // def square(x: Int): Int = x * x;
    // print(square(5));

    def halve(x: Double): Double = x / 2.0;
    print(halve(0.35));
}
