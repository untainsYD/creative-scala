import javax.lang.model.`type`.NullType
// Used on types, the | operator creates a so-called union type. The type A | B represents values that are either of the type A or of the type B.
// case class Username(name: String)
// case class Password(hash: BigInt)

// def help(id: Username | Password) =
//     val user = id match
//         case Username(name) => println(name)
//         case Password(hash) => println(hash)

// val name = Username("Martin")
// val password = Password(1234567891)

// help(name)
// help(password)

// val a = if true then name else password
// val b: Password | Username = if true then name else password

trait C[+T]
trait D
trait E
transparent trait X
class A extends C[A], D, X
class B extends C[B], D, E, X

// val x: Int | String

val x = 1
val y = "abc"
if true then x else y

x match
    case 1 => x
    case 2 => "abc"
    case 3 => List(1, 2, 3)


// Examples
def isIntOrString(t: Either[Int, String]): String =
    t match
        case Left(i) => "%d is an Integer".format(i)
        case Right(s) => "%s is a String".format(s)
        case null => "Error, nullable type"

println(isIntOrString(Left(10))) // prints "10 is an Integer"
println(isIntOrString(Right("hello"))) // prints "hello is a String"
println(isIntOrString(null))

sealed trait IntOrStringOrBool[T]
object IntOrStringOrBool
    implicit val intInstance: IntOrStringOrBool[Int] =
        new IntOrStringOrBool[Int] {}
    implicit val strInstance: IntOrStringOrBool[String] =
        new IntOrStringOrBool[String] {}
    implicit val boolInstance: IntOrStringOrBool[Boolean] =
        new IntOrStringOrBool[Boolean] {}

def isIntOrStringOrBool[T: IntOrStringOrBool](t: T): String =
    t match
        case i: Int => "%d is an Integer".format(i)
        case s: String => "%s is a String".format(s)
        case b: Boolean => "%b a Boolean".format(b)

println(isIntOrStringOrBool(10))
println(isIntOrStringOrBool("hello"))
println(isIntOrStringOrBool(true))

def isIntOrStringUnion(t: Int | String | Boolean) = {
    t match {
        case i: Int => "%d is an Integer".format(10)
        case s: String => "%s is a String".format(s)
        case b: Boolean => "%b is a Boolean".format(b)
    }
}
println(isIntOrStringUnion(10))  //prints "10 is an Integer"
println(isIntOrStringUnion("hello")) // prints "hello is a String"
println(isIntOrStringUnion(false)) // prints "true is a Boolean"


type FirstUnionT = String
type SecondUnionT = Int

def test(t: FirstUnionT | SecondUnionT | Null) = {
    t match {
        case f: FirstUnionT => println("First Union Type")
        case s: SecondUnionT => println("Second Union Type")
        case null => println("Null type")
    }
}

val first: FirstUnionT = "string"
val second: SecondUnionT = 10
val nullableTest: String | Null = null

test(first)
test(second)
test(nullableTest)

extension [T](x: T | Null) {
    inline def nn: T = {
        assert(x != null)
        x.asInstanceOf[T]
    }
}
