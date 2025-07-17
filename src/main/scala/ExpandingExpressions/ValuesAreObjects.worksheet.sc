// In Scala all values are objects. An object is a grouping of data and operations on that data. For example, 2 is an object. The data is the integer 2, and the operations on that data are familiar operations like +, -, and so on. We call operations of an object the object's methods.

// Method Calls
// We interact with objects by calling or invoking methods. For example, we can get the uppercase version of a String by calling its toUpperCase method.
"Titan!".toUpperCase
// res0: String = "TITAN!"

// Some methods accept parameters or arguments, which control how the method works. The take method, for example, takes characters from a String. We must pass a parameter to take to specify how many characters we want.
"Gilgamesh went abroad in the world".take(3)
// res1: String = "Gil"
"Gilgamesh went abroad in the world".take(9)
// res2: String = "Gilgamesh"

// A method call is an expression, and thus evaluates to an object. This means we can chain method calls together to make more complex programs:
"Titan!".toUpperCase.toLowerCase
// res3: String = "titan!"

"Gilgamesh went abroad in the world".substring(10, 14)
// res4: String = "went"

"Gilgamesh went abroad in the world".substring(10)
// res5: String = "went abroad in the world"
"Gilgamesh went abroad in the world".substring(10, 14)
// res6: String = "went"


// Method Call Syntax
// The syntax for a method call is
    // anExpression.methodName(param1, ...)
// or
    // anExpression.methodName
// where
    // anExpression is any expression (which evaluates to an object)
    // methodName is the name of the method
    // the optional param1, ... are one or more expressions evaluating to the parameters to the method.


// Operators
// We have said that all values are objects, and we call methods with the syntax object.methodName(parameter). How then do we explain expressions like 1 + 2?
// In Scala, and expression written a.b(c) can be written a b c. So these are equivalent:
1 + 2
// res7: Int = 3
1.+(2)
// res8: Int = 3
2.-(1.-(2))
2.+(2) + 2.*(4)
1.+(2.+(3.+(4)))
// This first way of calling a method is known as operator style. It is considered good style to only use operator style when the method is widely understand to be written that way. For example, we write 1 + 2 because everyone understands that notation better than 1.+(2). However, it is bad style to write "Gilgamesh" substring 4 instead of "Gilgamesh".substring(4) as substring is not widely known to be an operator.
"Gilgamesh" substring 4
"test".toLowerCase
