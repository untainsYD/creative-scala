import doodle.core._
import doodle.image._
import doodle.syntax.all._
import doodle.image.syntax.all._
import doodle.java2d._
import cats.effect.unsafe.implicits.global

object ParametricCurves extends App {
    // @fixme
    // def drawCurve(points: Int, marker: Image, curve: Angle => Point): Image = {
    //     val angles = (0 until points).map(i => i * 2 * Pi / points)
    //     val pts = angles.map(angle => curve(angle))
    //     val scene = marker.width * points, marker.height

    //     pts.zipWithIndex.foreach { case (pt, i) =>
    //         scene.place(marker, pt.x.toInt, pt.y.toInt)
    //     }
    // }

    // BEGIN: Exercise: Drawing a Parametric Curve
    val roseFn: Angle => Point = (angle: Angle) =>
        Point.cartesian(
            (angle * 7).cos * angle.cos * 100,
            (angle * 7).cos * angle.sin * 100
        )

    def parametricCircle(angle: Angle): Point = Point(100, angle)

    def drawCurveCircle(points: Int, marker: Image, curve: Angle => Point): Image = {
        val turn = Angle.one / points

        def loop(count: Int, acc: Image): Image = count match {
            case 0 => acc
            case n =>
                val angle = turn * n
                val pt = curve(angle)

                loop(n - 1, marker.at(pt).on(acc))
        }

        loop(points, marker.at(curve(Angle.zero)))
    }

    drawCurveCircle(12, Image.circle(5).fillColor(Color.hotpink), parametricCircle).draw()
    drawCurveCircle(12, Image.circle(5).fillColor(Color.hotpink), roseFn).draw()
    // END: exercise: drawing a parametric curve

    // BEGIN: Exercise: Parametric Spirals
    def parametricSpiral(angle: Angle): Point = Point((Math.exp(angle.toTurns) - 1) * 200, angle)
    // def parametricSpiral(angle: Angle): Point = Point(angle.toTurns * 100, angle) // WWKCD
    def drawCurveSpirals(points: Int, marker: Point => Image, curve: Angle => Point): Image = {
        val turn = Angle.one / points

        def loop(count: Int): Image =
        count match {
            case 0 => Image.empty
            case n =>
            // n: Int
            // marker: Image
            val pt: Point = curve(turn * n)
            val here: Image = marker(pt).at(pt)
            val recursive: Image = loop(n - 1)

            here.on(recursive)
        }

        loop(points)
    }

    drawCurveSpirals(12, pt => Image.circle(pt.angle.toTurns * 20).fillColor(Color.hotpink), parametricSpiral).draw()
    // END: exercise: parametric spirals

    // BEGIN: Exercise: Expressive Drawing
    // @todo
    // def parametricSpiralExpressive(angle: Angle): Point = Point((Math.exp(angle.toTurns) - 1) * 200, angle)
    // // def parametricSpiral(angle: Angle): Point = Point(angle.toTurns * 100, angle) // WWKCD
    // def drawCurveSpiralsExpressive(points: Int, marker: Point => Image, curve: Angle => Point): Image = {
    //     val turn = Angle.one / points

    //     def loop(count: Int): Image =
    //     count match {
    //         case 0 => Image.empty
    //         case n =>
    //         // n: Int
    //         // marker: Image
    //         val pt: Point = curve(turn * n)
    //         val here: Image = marker(pt).at(pt)
    //         val recursive: Image = loop(n - 1)

    //         here.on(recursive)
    //     }

    //     loop(points)
    // }

    // drawCurveSpiralsExpressive(12, pt => Image.circle(pt.angle.toTurns * 20).fillColor(Color.hotpink), parametricSpiralExpressive).draw()
    // END: exercise: expressive drawing

    println(120.degrees);
}
