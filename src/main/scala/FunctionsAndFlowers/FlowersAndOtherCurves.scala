import doodle.core._
import doodle.image._
import doodle.syntax.all._
import doodle.image.syntax.all._
import doodle.java2d._
import cats.effect.unsafe.implicits.global

def drawCurve(points: Int, marker: Point => Image, curve: Angle => Point): Image = {
    // val turn = (360 / points).degrees
    // val turn = Angle.one / points
    val turn = (1.0 / points).turns

    def loop(count: Int): Image = count match {
        case 0 => Image.empty
        case n =>
        // n: Int
        // marker: Image
        val pt: Point = curve(turn * n)
        val here: Image = marker(pt).at(pt)
        val recursive: Image = loop(n - 1)

        here.on(recursive)
        // image.beside(stackedImages(n - 1, image.rotate(90.degrees)))
    }

    loop(points)
}

object FlowersAndOtherCurves extends App {
    val rose7 = (angle: Angle) => Point((angle * 7).cos * 200, angle)

    def rose(k: Int): Angle => Point = (angle: Angle) => Point((angle * k).cos * 200, angle)

    def lissajous(a: Int, b: Int, offset: Angle): Angle => Point =
        (angle: Angle) => Point(100 * ((angle * a) + offset).sin, 100 * (angle * b).sin)

    // lissajous(5, 7, 10.degrees)

    val curve = lissajous(1, 5, 20.degrees)
    val marker: Point => Image = pt => Image.circle(15).fillColor(Color.lawngreen.spin(pt.angle))

    drawCurve(100, marker, curve).draw()
}
