import doodle.image.Image
import doodle.core.Color
import doodle.core._
import doodle.image._
import doodle.image.syntax.all._
import doodle.image.syntax.core._
import doodle.java2d._
import cats.effect.unsafe.implicits.global

object TheNaturalNumbers extends App {
    val box = Image.square(20).fillColor(Color.royalBlue) // FOUR SIDES
    val circle = Image.circle(50).fillColor(Color.paleTurquoise) // CENTRE

    // def cross(count: Int): Image = {
    //     count match {
    //         case 0 => circle
    //         case _ => {
    //             val horizontal = box beside cross(count - 1) beside box
    //             val vertical   = box above horizontal above box
    //             val result     = vertical
    //             result
    //         }
    //     }
    // }
    // cross(20).draw()

    def cross(count: Int): Image = {
        // *Image is a varargs parameter
        def concatenateVertically(images: Image*): Image = images.reduce(_ above _)
        def concatenateHorizontally(images: Image*): Image = images.reduce(_ beside _)

        count match {
            case 0 => circle
            case _ => {
                val innerCross = cross(count - 1)
                val line = concatenateHorizontally(box, innerCross, box)
                val result = concatenateVertically(box, line, box)

                result
            }
        }
    }
    // cross(20).draw()

    // // n = n * (n − 1) * (n − 2) * … * 3 * 2 * 1
    // def factorial(n: Int): Int = {
    //     def rec(n: Int, accumulator: Int): Int = {
    //         n match {
    //             case 0 => 1 * accumulator
    //             case _ => {
    //                 rec(n - 1, accumulator * n)
    //             }
    //         }
    //     }
    //     rec(n, 1)
    // }
    // print(factorial(5))

    // Simplified
    def factorial(n: Int): Int = {
        n match {
            case 0 => 1
            case n if n < 0 => throw new IllegalArgumentException("Input must be a non-negative integer")
            case _ => n * factorial(n - 1)
        }
    }
    // print(factorial(5))
}
