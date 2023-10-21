name := "Creative Scala book template"

scalaVersion := "3.3.0"

bspEnabled := false

// triggeredMessage := Watched.clearWhenTriggered
// autoStartServer := false

console / initialCommands := """
      |import doodle.core.*
      |import doodle.image.*
      |import doodle.image.syntax.all.*
      |import doodle.image.syntax.core.*
      |import doodle.java2d.*
      |import cats.effect.unsafe.implicits.global
    """.trim.stripMargin

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle" % "0.20.0"
)
