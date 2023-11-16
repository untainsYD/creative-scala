import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object Abstraction extends App {
    // First exercise
    // val box =
    //     Image.rectangle(40, 40)
    //         .strokeWidth(5.0)
    //         .strokeColor(Color.royalBlue.spin(30.degrees))
    //         .fillColor(Color.royalBlue)

    // var. I
    // val lineOfBoxes: IndexedSeq[Image] = for _ <- 1 to 5 yield box
    // lineOfBoxes.foldLeft(Image.empty)(_ beside _).draw()

    // var. II
    // val lineOfBoxes: Image =
    //     (for (_ <- 1 to 5) yield box).reduce(_ beside _)
    // lineOfBoxes.draw()

    // var. III
    // val lineOfBoxes: Image = List.fill(5)(box).reduce((box1, box2) => box1.beside(box2))
    // lineOfBoxes.draw()

    // Second exercise
    // val redCircle = Image.circle(120).fillColor(Color.red)
    // val whiteCircle = Image.circle(80).fillColor(Color.white)
    // val brownRectangle = Image.rectangle _
    // val greenRectangle = Image.rectangle(160, 50).fillColor(Color.green)

    // val finalImage =
    //     redCircle.scale(0.3, 0.3)
    //         .on(whiteCircle)
    //         .on(redCircle)
    //         .above(brownRectangle(10, 50).fillColor(Color.brown))
    //         .above(brownRectangle(50, 10).fillColor(Color.brown))
    //         .above(greenRectangle)

    // finalImage.draw()

    case class Roof() {
        def draw(): Image = Image.triangle(50, 30).fillColor(Color.brown)
    }

    case class FrontDoor() {
        def draw(): Image = {
            Image.rectangle(50, 15).fillColor(Color.red).above(
                Image
                    .rectangle(10, 25)
                    .fillColor(Color.black)
                    .on(Image.rectangle(50, 25).fillColor(Color.red))
                )
        }
    }

    case class House(roof: Roof, frontDoor: FrontDoor) {
        def draw(): Image = roof.draw().above(frontDoor.draw())
    }

    case class Tree() {
        def draw(): Image = {
            Image
                .circle(25)
                .fillColor(Color.green)
                .above(Image.rectangle(10, 20).fillColor(Color.brown))
        }
    }

    case class StreetSegment() {
        def draw(): Image = {
            Image
                .rectangle(30, 3)
                .fillColor(Color.yellow)
                .beside(Image.rectangle(15, 3).fillColor(Color.black))
                .above(Image.rectangle(45, 7).fillColor(Color.black))
        }
    }

    case class Scene(house: House, tree: Tree, street: Image) {
        def draw(): Image = house.draw().beside(tree.draw()).above(street)
    }

    def buildScene(): Image = {
        val roof = Roof()
        val frontDoor = FrontDoor()
        val house = House(roof, frontDoor)
        val tree = Tree()
        val streetSegments = List.fill(3)(StreetSegment())

        // val street = streetSegments.foldLeft(Image.empty) {
        //     case (accumulated, segment) => accumulated.beside(segment.draw())
        // }
        val street = streetSegments.foldLeft(Image.empty)(_ beside _.draw())

        val scene = List.fill(3)(Scene(house, tree, street))
        // scene.draw().beside(scene.draw()).beside(scene.draw()).noStroke
        scene.foldLeft(Image.empty)(_ beside _.draw()).noStroke
    }

    buildScene().draw()
}
