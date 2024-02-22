import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.image.Image.Elements.StrokeWidth

object AuxiliaryParameters extends App:
    def gradientBoxes(size: Int, count: Int, color: Color, angle: Double): Image =
        count match
            case 0 => Image.empty
            case n =>
                println(s"Color: $color, Angle: $angle")
                Image.square(size).fillColor(color) beside gradientBoxes(size + 10, n - 1, color.spin(angle.degrees * 1.25), angle)

    gradientBoxes(30, 5, Color.blue, 15).draw()
