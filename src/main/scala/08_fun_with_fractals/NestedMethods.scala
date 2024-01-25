import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object NestedMethods extends App {
    def cross(count: Int): Image = {
        val unit = {
            println("Creating unit")
            Image.circle(20)
        }

        def loop(count: Int): Image = {
            count match {
                case 0 => unit
                case n => unit.beside(unit.above(cross(n - 1)).above(unit)).beside(unit)
            }
        }

        loop(count);
    }

    cross(10);
}
