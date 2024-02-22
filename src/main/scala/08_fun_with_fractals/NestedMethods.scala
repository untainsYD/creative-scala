import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.image.Image.Elements.StrokeWidth

object NestedMethods extends App {
    def cross(count: Int): Image = {
        val unit = {
            println("Creating unit")
            Image.circle(50).fillColor(Color.red).strokeColor(Color.black).strokeWidth(10)
        }

        def loop(count: Int): Image = {
            count match {
                case 0 => unit
                case n => unit.beside(unit.above(loop(n - 1)).above(unit)).beside(unit)
            }
        }

        loop(count);
    }
    cross(10).draw();

    def boxingClever(count: Int): Image = {
        val boxItem = {
            println("TEST")
            Image.square(20).fillColor(Color.royalBlue)
        }

        def boxes(count: Int): Image = {
            count match {
                case 0 => Image.empty
                case n => boxItem.beside(boxes(n-1))
            }
        }

        boxes(count)
    }
    boxingClever(10).draw()
}
