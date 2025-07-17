import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.syntax.normalized

object CreatingColours extends App {
    Color.rgb(255.uByte, 255.uByte, 255.uByte) // White
    Color.rgb(0.uByte, 0.uByte, 0.uByte) // Black
    Color.rgb(255.uByte, 0.uByte, 0.uByte) // Red

    // A byte is a number with 256 possible values, which takes 8 bits within a computer to represent. A signed byte has integer values from -128 to 127, while an unsigned byte ranges from 0 to 255.

    // object trianglesColours {
    //     val aboveMiddle = Color.hsl(259.degrees, 0.59, 0.69)
    //     val belowLeft   = Color.hsl(228.degrees, 0.59, 0.69)
    //     val belowRight  = Color.hsl(288.degrees, 0.59, 0.69)
    // }

    // object trianglesColoursStrokes {
    //     val aboveMiddle = Color.hsl(248.degrees, 0.39, 0.39)
    //     val belowLeft   = Color.hsl(228.degrees, 0.39, 0.39)
    //     val belowRight  = Color.hsl(278.degrees, 0.39, 0.39)
    // }

    // (Image
    //     .equilateralTriangle(100)
    //     .strokeWidth(5)
    //     .strokeColor(trianglesColoursStrokes.aboveMiddle)
    //     .fillColor(trianglesColours.aboveMiddle)
    //     .above(
    //         Image
    //             .equilateralTriangle(100)
    //             .strokeWidth(5)
    //             .strokeColor(trianglesColoursStrokes.belowLeft)
    //             .fillColor(trianglesColours.belowLeft)
    //             .beside(
    //                 Image
    //                     .equilateralTriangle(100)
    //                     .strokeWidth(5)
    //                     .strokeColor(trianglesColoursStrokes.belowRight)
    //                     .fillColor(trianglesColours.belowRight)
    //             )
    //     )
    // ).draw()

    object Triangles {
        case class Colours(fill: Color, stroke: Color)

        val aboveMiddle = Colours(
            Color.hsl(259.degrees, 0.59, 0.69),
            Color.hsl(248.degrees, 0.39, 0.39),
        )
        val belowLeft = Colours(
            Color.hsl(228.degrees, 0.59, 0.69),
            Color.hsl(228.degrees, 0.39, 0.39)
        )
        val belowRight = Colours(
            Color.hsl(288.degrees, 0.59, 0.69),
            Color.hsl(278.degrees, 0.39, 0.39)
        )

        case class Sizes(figure: Int, stroke: Int)

        def createTriangle(width: Sizes, strokeWidth: Sizes, colours: Colours): Image = {
            Image
                .equilateralTriangle(width.figure)
                .strokeWidth(strokeWidth.stroke)
                .strokeColor(colours.stroke)
                .fillColor(colours.fill)
        }

        val figureSizes = Sizes(100, 5)
        // def createTriangleColorized(colour: Colours): Image = createTriangle(Triangles.figureSizes, Triangles.figureSizes, colour)
        def createTriangleColorized(input: Any): Image = input match {
            case c: Colours => createTriangle(figureSizes, figureSizes, c)
            case s: Sizes => createTriangle(s, s, aboveMiddle)

            case _ => throw new IllegalArgumentException("Invalid input type")
        }
    }

    val aboveMiddleTriangle = Triangles.createTriangleColorized(Triangles.figureSizes)
    val belowLeftTriangle   = Triangles.createTriangleColorized(Triangles.belowLeft)
    val belowRightTriangle  = Triangles.createTriangleColorized(Triangles.belowRight)

    aboveMiddleTriangle.above(belowLeftTriangle.beside(belowRightTriangle)).draw()
}
