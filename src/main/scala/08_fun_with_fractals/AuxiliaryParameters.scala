import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.image.Image.Elements.StrokeWidth

object AuxiliaryParameters extends App:
    def gradientBoxes(size: Int, count: Int, color: Color, angle: Double): Image =
        (count, color, angle) match
            case (0, _, _) => Image.empty
            case (a: Int, b: Color, c: Double) =>
                println(s"Color: $b, Angle: $c")
                Image.square(size).fillColor(b) beside gradientBoxes(size + 10, a - 1, b.spin(c.degrees * 1.25), c)

    gradientBoxes(30, 5, Color.blue, 15).draw()
