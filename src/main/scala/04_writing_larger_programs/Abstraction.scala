import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*

object Abstraction extends App {
    println("test");

    // Image.rectangle(40, 40)
    //      .strokeWidth(5.0)
    //      .strokeColor(Color.royalBlue.spin(30.degrees))
    //      .fillColor(Color.royalBlue)
    //      .beside(
    //        Image.rectangle(40, 40)
    //          .strokeWidth(5.0)
    //          .strokeColor(Color.royalBlue.spin(30.degrees))
    //          .fillColor(Color.royalBlue)
    //      ).beside(
    //         Image.rectangle(40, 40)
    //           .strokeWidth(5.0)
    //           .strokeColor(Color.royalBlue.spin(30.degrees))
    //           .fillColor(Color.royalBlue)
    //      ).beside(
    //         Image.rectangle(40, 40)
    //              .strokeWidth(5.0)
    //              .strokeColor(Color.royalBlue.spin(30.degrees))
    //             .fillColor(Color.royalBlue)
    //      ).beside(
    //         Image.rectangle(40, 40)
    //              .strokeWidth(5.0)
    //              .strokeColor(Color.royalBlue.spin(30.degrees))
    //              .fillColor(Color.royalBlue)
    //      )
}
