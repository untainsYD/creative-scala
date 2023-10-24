// class A {
//     class B
//     var b: Option[B] = None
// }

// val a1 = new A
// val a2 = new A
// val b1 = new a1.B
// val b2 = new a2.B

// a1.b = Some(b1)
// a2.b = Some(b1) // does not compile


// class Franchise(name: String) {
//     case class Character(name: String)

//     def createFanFictionWith(lovestruck: Character, objectOfDesire: Character): (Character, Character) = (lovestruck, objectOfDesire)
// }

// val starTrek = new Franchise("Star Trek")
// val starWars = new Franchise("Star Wars")

// val quark = starTrek.Character("Quark")
// val jadzia = starTrek.Character("Jadzia Dax")

// val luke = starWars.Character("Luke Skywalker")
// val yoda = starWars.Character("Yoda")

// starTrek.createFanFictionWith(lovestruck = jadzia, objectOfDesire = luke)
// // found   : starWars.Character
// // required: starTrek.Character
// //                starTrek.createFanFictionWith(lovestruck = jadzia, objectOfDesire = luke)


object AwesomeDB {
    abstract class Key(name: String) {
        type Value
    }
}

import AwesomeDB.Key
class AwesomeDB {
    import collection.mutable.Map
    val data = Map.empty[Key, Any]
    def get(key: Key): Option[key.Value] = data.get(key).asInstanceOf[Option[key.Value]]
    def set(key: Key)(value: key.Value): Unit = data.update(key, value)
}

trait IntValued extends Key {
    type Value = Int
}
trait StringValued extends Key {
    type Value = String
}
object Keys {
    val foo = new Key("foo") with IntValued
    val bar = new Key("bar") with StringValued
}

val dataStore = new AwesomeDB
dataStore.set(Keys.foo)(23)
val i: Option[Int] = dataStore.get(Keys.foo)
// dataStore.set(Keys.foo)("23") // does not compile
