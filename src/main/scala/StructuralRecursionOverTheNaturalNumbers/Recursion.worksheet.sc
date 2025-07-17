def rec(i: Int): Unit = {
    i match {
        case 0 => println(i)
        case _ => {
            println(i)
            rec(i - 1)
        }
    }
}

// Example usage
rec(3)
