// The simplest expressions are literals. Here's a literal expression:
3 // res0: Int = 3

// A literal evaluates to "itself": how we write the expression and how the worksheet prints the value are the same. Remember though, there is a difference between the written representation of a value and its actual representation in the computer's memory.


// Scala has many different forms of literals. We've already seen Int literals. There is a different type, and a different literal syntax, for what are called floating point numbers. This corresponds to a computer's approximation of the real numbers. Here's an example:
0.1
0.1 / 3
// As you can see, the type is called Double.


// Numbers are well and good, but what about text? Scala's String type represents a sequence of characters. We write literal strings by putting their contents in double quotes.
"To be fond of dancing was a certain step towards falling in love."
// res2: String = "To be fond of dancing was a certain step towards falling in love."


// Sometimes we want to write strings that span several lines. We can do this by using triple double quotes, as below.

"""
A new, a vast, and a powerful language is developed for the future use of analysis,
in which to wield its truths so that these may become of more speedy and accurate
practical application for the purposes of mankind than the means hitherto in our
possession have rendered possible.

  -- Ada Lovelace
"""
// res3: String = """
//       A new, a vast, and a powerful language is developed for the future use of analysis,
//       in which to wield its truths so that these may become of more speedy and accurate
//       practical application for the purposes of mankind than the means hitherto in our
//       possession have rendered possible.
//
//         -- Ada Lovelace
//       """

val tripleDouble = """
test
  \  test
"""

tripleDouble + "1"


// A String is a sequence of characters. Characters themselves have a type, Char, and character literals are written in single quotes.
'a'
// res4: Char = 'a'
"a"
'a' + 'b'
"a" + "b"

// In Java or Scala, the SIZE and BYTES constants in the java.lang.Character class represent different properties of a char type:
// - SIZE: It denotes the size of a char in bits. In Java and Scala, the SIZE constant for the char type is typically 16, indicating that a char is represented using 16 bits.
// - BYTES: This constant, however, does not directly apply to the char type. It represents the size of a char in bytes only when it is used in conjunction with other data types, like arrays. Since a char is 2 bytes in Java and Scala, the BYTES constant would be 2.
java.lang.Character.SIZE
java.lang.Character.BYTES

// Finally we'll look at the literal representations of the Boolean type, named after English logician George Boole. This fancy name just means a value that can be either true or false, and this indeed is how we write boolean literals.
true
// res5: Boolean = true
false
// res6: Boolean = false


// With literal expressions, we can create values, but we won't get very far if we can't somehow manipulate the values we've created. We've seen a few examples of more complex expressions like 1 + 2. In the next section, we'll learn about objects and methods, which will allow us to understand how this, and more interesting expressions, work.
