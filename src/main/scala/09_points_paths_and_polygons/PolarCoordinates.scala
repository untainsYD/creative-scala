import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.image.Image.Elements.StrokeWidth

object PolarCoordinates extends App {
    // val cartesian = Point(3, 4)

    // val ninety = 90.degrees

    // val radians = 2.radians
    // val fullTurn = 1.turns

    // val polar = Point(5, 45.degrees)

    // val dot = Image.circle(5).fillColor(Color.darkViolet)
    // val vertices =
    //     dot.at(Point(100, 45.degrees))
    //         .on(dot.at(Point(100, 135.degrees)))
    //         .on(dot.at(Point(100, 225.degrees)))
    //         .on(dot.at(Point(100, 315.degrees)))

    // val c = Image.circle(40)
    // val c1 = c.beside(c.at(10, 10)).beside(c.at(10, -10)).debug
    // val c2 = c.debug.beside(c.at(10, 10).debug).beside(c.at(10, -10).debug)
    // val c3 = c.debug.beside(c.debug.at(10, 10)).beside(c.debug.at(10, -10))

    // val example = c1.above(c2).above(c3)
    // example.draw()

    def polygonPoints(sides: Int, r: Int): Image =
        val dot = Image.circle(5).fillColor(Color.darkViolet)

        def points(point: Int): Image =
            point match
                case 0 => Image.empty
                // case n => dot.at(Point(r, (360.degrees / sides) * n)).on(points(n - 1)) // degrees
                case n => dot at Point(r, (1.0 / sides).turns * n) on (points(n - 1)) // turns
                // case n =>
                //     val angle = (2 * math.Pi / sides) * n
                //     dot.at(Point(r * math.cos(angle), r * math.sin(angle))) on points(n - 1) // custom radians


        points(sides)

        // sides = 5, r = 10 | turns = 0.2
        // in points, n = 1, what angle is used?
        //   10 degrees.  r.degrees * n = 10.degrees * 1 = 10.degrees
        // What angle should be used?
        //   should be a multiple of 72 degrees (and if n = 1 should probably be 72 degrees)

    val result = polygonPoints(3, 100)
                    .fillColor(Color.crimson)
                    .beside(polygonPoints(5, 50).fillColor(Color.lawngreen))
                    .beside(polygonPoints(7, 50).fillColor(Color.dodgerBlue))

    result.draw()

    // val vertices =
    //     dot.at(Point(100, 0.degrees))
    //         .on(dot.at(Point(100, 60.degrees)))
    //         .on(dot.at(Point(100, 120.degrees)))
    //         .on(dot.at(Point(100, 180.degrees)))
    //         .on(dot.at(Point(100, 240.degrees)))
    //         .on(dot.at(Point(100, 300.degrees)))
}
