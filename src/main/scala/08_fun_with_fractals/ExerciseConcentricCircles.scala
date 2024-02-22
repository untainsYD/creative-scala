import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.image.Image.Elements.StrokeWidth

object ExerciseConcentricCircles extends App:
    def concentricCircles(size: Int, count: Int, fillColor: Color, strokeColor: Color): Image =
        count match
            case 0 => Image.empty
            case n => Image.circle(size).strokeColor(strokeColor) on concentricCircles(size + 10, n - 1, fillColor, strokeColor)

    // concentricCircles(20, 10, Color.white, Color.turquoise).draw()

    def colouredConcentricCircles(size: Int, count: Int, color: Color, angle: Angle): Image =
        def unit(size: Int, color: Color): Image = Image.circle(size).noFill.strokeColor(color)

        def compound(size: Int, count: Int, color: Color, angle: Angle): Image =
            count match
                case 0 => Image.empty
                case currentCount => unit(size, color) on compound(size + 10, currentCount - 1, color.spin(angle), angle + 15.degrees)
                    // println(s"Color: $color, Angle: $angle")

        compound(size, count, color, angle)

    // colouredConcentricCircles(15, 10, Color.red, 15.degrees).draw()

    def fadingConcentricCircles(size: Int, count: Int, color: Color): Image =
        def unit(size: Int, color: Color): Image = Image.circle(size).noFill.strokeColor(color).strokeWidth(2.25)

        def compound(size: Int, count: Int, color: Color): Image =
            count match
                case 0 => Image.empty
                case n => unit(size, color) on compound(size + 10, n - 1, color.fadeOut(0.025.normalized)) // works

        compound(size, count, color)

    fadingConcentricCircles(70, 100, Color.red).draw()
