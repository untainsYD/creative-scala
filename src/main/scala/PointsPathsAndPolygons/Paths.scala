import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.image.Image.Elements.StrokeWidth

object Paths extends App {
    val hexagonPath =
        ClosedPath.empty
            .moveTo(100, 0.degrees)
            .lineTo(100, 60.degrees)
            .lineTo(100, 120.degrees)
            .lineTo(100, 180.degrees)
            .lineTo(100, 240.degrees)
            .lineTo(100, 300.degrees)

    val hexagonImage = Image.path(hexagonPath)
    // hexagonImage.draw()

    // @see Utilities section http://www.creativescala.org/doodle/pictures/path.html for more details
    // Image.regularPolygon(7, 120).draw()
    // Image.roundedRectangle(100, 50, 20).draw()

    def regularPolygon(sides: Int, radius: Double): Image =
        val rotation = 360.degrees / sides

        def loop(count: Int): ClosedPath = count match
            case 0 => ClosedPath.empty.moveTo(radius, 0.degrees)
            case n => loop(n-1).lineTo(radius, rotation * n)

        Image.path(loop(sides))

    // regularPolygon(3, 25)
    //     .on(regularPolygon(5, 50))
    //     .on(regularPolygon(7, 75))
    //     .draw()


    def starPolygon(sides: Int, radius: Int, miss: Int): Image = {
        val turn = (1.0 / sides).turns

        def builder(count: Int, path: ClosedPath): ClosedPath = count match {
            case 0 => path
            case n =>
                val angle = turn * ((n - 1) * miss + 1)
                val point = Point(radius * angle.cos, radius * angle.sin)

                println(angle);
                println(point);

                // if n == sides -> initial point (move point) | lineTo -> draw line to the point
                builder(n - 1, if (n == sides) path.moveTo(point) else path.lineTo(point))
        }

        Image.path(builder(sides, ClosedPath.empty))
    }

    val allStars = starPolygon(5, 100, 2) beside starPolygon(8, 80, 3) beside starPolygon(12, 120, 5)
    allStars.draw()
}
